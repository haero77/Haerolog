package com.haerolog.domain.auth.exception;

import com.haerolog.global.error.exception.HaerologException;
import org.springframework.http.HttpStatus;

public class InvalidLogInformation extends HaerologException {

	private static final String MESSAGE = "아이디/비밀번호가 올바르지 않습니다.";

	public InvalidLogInformation() {
		super(MESSAGE);
	}

	@Override
	public int getStatusCode() {
		return HttpStatus.BAD_REQUEST.value();
	}

}
