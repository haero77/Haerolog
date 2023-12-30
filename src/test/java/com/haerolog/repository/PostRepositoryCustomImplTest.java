package com.haerolog.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.haerolog.common.support.IntegrationTestSupport;
import com.haerolog.domain.Post;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PostRepositoryCustomImplTest extends IntegrationTestSupport {

    @Autowired
    PostRepository postRepository;

    @Test
    void getList() {
        postRepository.saveAll(
                List.of(createPost("title1", "content1"),
                        createPost("title2", "content2"))
        );

        List<Post> actual = postRepository.getList(1); // 프록시 생성되고, 프록시를 이용하여 getList 실행.

        assertThat(actual).hasSize(2);
    }

    private Post createPost(String title, String content) {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }

}