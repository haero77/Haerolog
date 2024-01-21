package com.haerolog.domain.post.exception;

public abstract class HaerologException extends RuntimeException {

	public HaerologException(String message) {
		super(message);
	}

	public HaerologException(String message, Throwable cause) {
		super(message, cause);
	}

	public abstract int getStatusCode();

}
