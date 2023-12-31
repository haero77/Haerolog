package com.haerolog.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.haerolog.common.fixture.PostFixture;
import com.haerolog.common.support.IntegrationTestSupport;
import com.haerolog.domain.Post;
import com.haerolog.request.PostSearch;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PostRepositoryCustomImplTest extends IntegrationTestSupport {

    @Autowired
    PostRepository sut;

    @Test
    void getList() {
        sut.save(PostFixture.createPost("title1", "content1"));
        sut.save(PostFixture.createPost("title2", "content2"));

        PostSearch postSearch = PostSearch.builder()
                .page(1)
                .size(2)
                .build();

        List<Post> actual = sut.getList(postSearch); // 프록시 생성되고, 프록시를 이용하여 getList 실행.

        assertAll(
                () -> assertThat(actual).hasSize(2),
                () -> assertThat(actual.get(0).getTitle()).isEqualTo("title2"),
                () -> assertThat(actual.get(1).getTitle()).isEqualTo("title1")
        );
    }

}