package com.haerolog.domain.user.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

	private final Long id;
	private final String name;
	private final String email;
	private final String password;

	@Builder
	private User(Long id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public static User of(String name, String email, String password) {
		return User.builder()
				.name(name)
				.email(email)
				.password(password)
				.build();
	}

}
