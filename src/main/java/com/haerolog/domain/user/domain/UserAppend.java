package com.haerolog.domain.user.domain;

import lombok.Builder;

public class UserAppend {

	private final String name;
	private final String email;
	private final String password;

	@Builder
	private UserAppend(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User toModel() {
		return User.of(name, email, password);
	}

}
