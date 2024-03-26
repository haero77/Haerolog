package com.haerolog.domain.auth.api;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SessionResponse {

    private final String accessToken;

    @Builder
    private SessionResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public static SessionResponse fromAccessToken(String accessToken) {
        return SessionResponse.builder()
                .accessToken(accessToken)
                .build();
    }

}
