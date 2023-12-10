package com.haerolog.api.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.haerolog.domain.Post;
import com.haerolog.repository.PostRepository;
import com.haerolog.request.PostCreate;
import com.haerolog.response.PostResponse;
import com.haerolog.service.PostService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    public void clean() {
        postRepository.deleteAllInBatch();
    }

    @DisplayName("글 작성")
    @Test
    void test1() {
        // given
        PostCreate postCreate = PostCreate.builder()
                .title("제목")
                .content("내용")
                .build();

        // when
        postService.write(postCreate);

        // then
        assertThat(postRepository.count()).isEqualTo(1);

        Post post = postRepository.findAll().get(0);
        assertThat(post.getTitle()).isEqualTo("제목");
        assertThat(post.getContent()).isEqualTo("내용");
    }

    @DisplayName("글 1개 조회")
    @Test
    void test2() {
        // given
        Post requestPost = Post.builder()
                .title("123456789012345")
                .content("content")
                .build();
        postRepository.save(requestPost);

        // when
        PostResponse response = postService.get(requestPost.getId());

        // then
        assertThat(response).isNotNull();
        assertThat(response.getTitle()).isEqualTo("1234567890");
        assertThat(response.getContent()).isEqualTo("content");
    }

    @DisplayName("글 1페이지 조회")
    @Test
    void test3() {
        // given
        List<Post> requestPosts = IntStream.rangeClosed(1, 30) // for int i = 1 to 30
                .mapToObj(i -> {
                    return Post.builder()
                            .title("제목" + i)
                            .content("컨텐츠" + i)
                            .build();
                })
                .collect(Collectors.toList());

        postRepository.saveAll(requestPosts);

        // when
        List<PostResponse> actual = postService.getList(0);

        // then
        Assertions.assertAll(
                () -> assertThat(actual).hasSize(5),
                () -> assertThat(actual.get(0).getTitle()).isEqualTo("제목30"),
                () -> assertThat(actual.get(4).getTitle()).isEqualTo("제목26")
        );
    }

}