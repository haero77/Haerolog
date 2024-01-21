package com.haerolog.domain.post.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * status -> 400
 */
@Getter
public class InvalidRequest extends HaerologException{

	private static final String MESSAGE = "잘못된 요청입니다.";

	private final String fieldName;
	private final String message;

	public InvalidRequest(String fieldName, String message1) {
		super(MESSAGE);
		this.fieldName = fieldName;
		this.message = message1;
	}

	@Override
	public int getStatusCode() {
		return HttpStatus.BAD_REQUEST.value();
	}

}
