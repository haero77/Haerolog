package com.haerolog.global.error.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * status -> 400
 */
@Getter
public class InvalidRequestException extends HaerologException {

	private static final String MESSAGE = "잘못된 요청입니다.";

	public InvalidRequestException(String fieldName, String message) {
		super(MESSAGE);
		super.addValidation(fieldName, message);
	}

	@Override
	public int getStatusCode() {
		return HttpStatus.BAD_REQUEST.value();
	}

}
