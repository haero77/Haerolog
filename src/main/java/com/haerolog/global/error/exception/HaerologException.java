package com.haerolog.global.error.exception;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public abstract class HaerologException extends RuntimeException {

	private final Map<String, String> validation = new HashMap<>(); // <fieldName, message>

	public HaerologException(String message) {
		super(message);
	}

	public HaerologException(String message, Throwable cause) {
		super(message, cause);
	}

	public abstract int getStatusCode();

	public void addValidation(String fieldName, String message) {
		validation.put(fieldName, message);
	}

}
