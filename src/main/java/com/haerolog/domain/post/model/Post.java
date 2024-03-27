package com.haerolog.domain.post.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Post {

    private final Long id;
    private final String title;
    private final String content;

    @Builder
    private Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

}
