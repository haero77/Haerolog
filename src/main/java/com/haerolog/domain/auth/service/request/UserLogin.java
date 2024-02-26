package com.haerolog.domain.auth.service.request;

import lombok.Builder;

public class UserLogin {

	private final String email;
	private final String password;

	@Builder
	private UserLogin(String email, String password) {
		this.email = email;
		this.password = password;
	}

}
