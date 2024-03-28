package com.haerolog.domain.auth.service.session;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SessionAppend {

    private final Long userId;

    @Builder
    private SessionAppend(Long userId) {
        this.userId = userId;
    }

    public static SessionAppend fromUserId(Long userId) {
        return SessionAppend.builder()
                .userId(userId)
                .build();
    }

}
