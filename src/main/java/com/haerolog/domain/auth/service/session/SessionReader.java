package com.haerolog.domain.auth.service.session;

import com.haerolog.domain.auth.exception.SessionNotFoundException;
import com.haerolog.domain.auth.model.Session;
import com.haerolog.domain.auth.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionReader {

    private final SessionRepository sessionRepository;

    public Session getById(Long sessionId) {
        return sessionRepository.findById(sessionId)
                .orElseThrow(() -> SessionNotFoundException.from(sessionId));
    }

}
