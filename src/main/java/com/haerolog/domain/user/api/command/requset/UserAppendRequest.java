package com.haerolog.domain.user.api.command.requset;

import com.haerolog.domain.user.service.UserAppend;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UserAppendRequest {

	@NotBlank
	private String name;

	@NotBlank
	private String email;

	@NotBlank
	private String password;

	public UserAppend toUserAppend() {
		return UserAppend.builder()
				.name(name)
				.email(email)
				.password(password)
				.build();
	}

}
