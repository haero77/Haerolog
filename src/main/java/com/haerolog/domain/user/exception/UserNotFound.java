package com.haerolog.domain.user.exception;

import com.haerolog.global.error.exception.NotFoundException;

public class UserNotFound extends NotFoundException {

	private static final String MESSAGE_FORMAT = "Cannot find User matching userId=%d";

	public UserNotFound(Long userId) {
		super(String.format(MESSAGE_FORMAT, userId));
	}

	public UserNotFound(String message) {
		super(message);
	}

}
