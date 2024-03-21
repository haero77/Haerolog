package com.haerolog.domain.auth.service;

import com.haerolog.domain.auth.model.Session;
import com.haerolog.domain.auth.service.port.SessionRepository;
import com.haerolog.domain.common.service.port.UuidHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionAppender {

    private final SessionRepository sessionRepository;
    private final UuidHolder uuidHolder;

    public void append(SessionAppend sessionAppend) {
        Session newSession = Session.from(uuidHolder, sessionAppend.getUserId());
        sessionRepository.save(newSession);
    }

}
