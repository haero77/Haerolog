package com.haerolog.global.error.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * status -> 400
 */
@Getter
public class Unauthorized extends HaerologException {

	private static final String MESSAGE = "인증되지 않은 사용자입니다.";

	public Unauthorized() {
		super(MESSAGE);
	}

	@Override
	public int getStatusCode() {
		return HttpStatus.UNAUTHORIZED.value();
	}

}
