package com.haerolog.domain.auth.model;

import com.haerolog.domain.common.service.port.UuidHolder;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Session {

	private final Long id;
	private final String accessToken;
	private final Long userId;

	@Builder
	private Session(Long id, String accessToken, Long userId) {
		this.id = id;
		this.accessToken = accessToken;
        this.userId = userId;
    }

	public static Session from(UuidHolder uuidHolder, Long userId) {
		return Session.builder()
				.accessToken(uuidHolder.random())
				.userId(userId)
				.build();
	}

}
