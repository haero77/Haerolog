package com.haerolog.domain.user.exception;

import com.haerolog.global.error.exception.NotFoundException;

public class UserNotFoundExcpetion extends NotFoundException {

	private static final String MESSAGE_FORMAT = "Cannot find User matching userId=%d";

	public UserNotFoundExcpetion(Long userId) {
		super(String.format(MESSAGE_FORMAT, userId));
	}

	public UserNotFoundExcpetion(String message) {
		super(message);
	}

}
