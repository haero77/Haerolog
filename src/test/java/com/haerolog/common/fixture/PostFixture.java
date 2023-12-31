package com.haerolog.common.fixture;

import com.haerolog.domain.Post;

public class PostFixture {

    public static Post createPost(String title, String content) {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }

}
