package com.haerolog.domain.post.service.request;

import com.haerolog.domain.user.dto.UserId;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostAppend {

    private final String title;
    private final String content;
    private final UserId userId;

    @Builder
    private PostAppend(String title, String content, UserId userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

}
