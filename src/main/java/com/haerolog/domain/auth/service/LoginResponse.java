package com.haerolog.domain.auth.service;

import lombok.Getter;

@Getter
public class LoginResponse {

	private final String accessToken;

	public LoginResponse(String accessToken) {
		this.accessToken = accessToken;
	}

}
