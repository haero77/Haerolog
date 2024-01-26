package com.haerolog.global.error.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HaerologException {

	public NotFoundException(String message) {
		super(message);
	}

	@Override
	public int getStatusCode() {
		return HttpStatus.NOT_FOUND.value();
	}

}
