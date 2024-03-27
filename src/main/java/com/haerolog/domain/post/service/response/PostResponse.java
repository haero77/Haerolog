package com.haerolog.domain.post.service.response;

import com.haerolog.domain.post.infrastructure.repository.PostEntity;
import lombok.Builder;
import lombok.Getter;

/**
 * 서비스 정책에 맞는 클래스
 */
@Getter
@Builder
public class PostResponse {

    private final Long id;
    private final String title;
    private final String content;

    public PostResponse(PostEntity post) {
        this(post.getId(), post.getTitle(), post.getContent());
    }

    @Builder
    private PostResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title.substring(0, Math.min(title.length(), 10));
        this.content = content;
    }

}
