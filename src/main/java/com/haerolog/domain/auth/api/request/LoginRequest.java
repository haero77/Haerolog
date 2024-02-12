package com.haerolog.domain.auth.api.request;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@ToString
public class LoginRequest {

	@NotBlank
	private String email;

	@NotBlank
	private String password;

	public LoginRequest() {
	}

	@Builder
	private LoginRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}

}
