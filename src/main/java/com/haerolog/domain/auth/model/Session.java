package com.haerolog.domain.auth.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Session {

	private final Long id;
	private final String accessToken;

	@Builder
	private Session(Long id, String accessToken) {
		this.id = id;
		this.accessToken = accessToken;
	}

}
