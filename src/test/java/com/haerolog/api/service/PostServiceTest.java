package com.haerolog.api.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.haerolog.common.support.IntegrationTestSupport;
import com.haerolog.domain.post.domain.Post;
import com.haerolog.domain.post.repository.PostRepository;
import com.haerolog.domain.post.service.PostService;
import com.haerolog.domain.post.service.request.PostCreate;
import com.haerolog.domain.post.service.request.PostSearch;
import com.haerolog.domain.post.service.response.PostResponse;
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
class PostServiceTest extends IntegrationTestSupport {

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

    @DisplayName("글 여러개 조회")
    @Test
    void getList() {
        List<Post> posts = IntStream.rangeClosed(1, 20) // for int i = 1 to 20
                .mapToObj(i -> Post.builder()
                        .title("제목" + i)
                        .content("컨텐츠" + i)
                        .build())
                .collect(Collectors.toList());
        postRepository.saveAll(posts);

        PostSearch postSearch = PostSearch.builder()
                .page(1)
                .build();

        List<PostResponse> actual = postService.getList(postSearch);

        Assertions.assertAll(
                () -> assertThat(actual).hasSize(20),
                () -> assertThat(actual.get(0).getTitle()).isEqualTo("제목20"),
                () -> assertThat(actual.get(9).getTitle()).isEqualTo("제목11")
        );
    }

}