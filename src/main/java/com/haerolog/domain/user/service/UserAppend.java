package com.haerolog.domain.user.service;

import com.haerolog.domain.user.model.User;
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
		return User.builder()
				.name(this.name)
				.email(this.email)
				.password(this.password)
				.build();
	}

}
