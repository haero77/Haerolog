package com.haerolog.domain.auth.exception;

import com.haerolog.global.error.exception.HaerologException;
import org.springframework.http.HttpStatus;

public class SessionNotFoundException extends HaerologException {

    private static String MESSAGE_FORMAT = "Cannot find Session for sessionId=%d";

    public SessionNotFoundException(String message) {
        super(message);
    }

    public static SessionNotFoundException from(Long sessionId) {
        return new SessionNotFoundException(String.format(MESSAGE_FORMAT, sessionId));
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }

}
