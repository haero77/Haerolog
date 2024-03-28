package com.haerolog.domain.auth.service.login;

import lombok.Getter;

@Getter
public class LoginResponse {

	private final String accessToken;

	public LoginResponse(String accessToken) {
		this.accessToken = accessToken;
	}

}
