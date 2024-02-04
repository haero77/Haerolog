package com.haerolog.global.config.auth.data;

import lombok.Getter;

/**
 * 인증이 필요하면 UserSession DTO를 컨트롤러에서 받는다고 생각.
 */
@Getter
public class UserSession {

	private final Long id;

	public UserSession(Long id) {
		this.id = id;
	}

}
