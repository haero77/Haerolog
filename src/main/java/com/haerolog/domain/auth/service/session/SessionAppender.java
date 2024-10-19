package com.haerolog.domain.auth.service.session;

import com.haerolog.domain.auth.model.Session;
import com.haerolog.domain.auth.repository.SessionRepository;
import com.haerolog.domain.user.model.User;
import com.haerolog.domain.user.service.UserReader;
import com.haerolog.global.service.UuidHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionAppender {

    private final SessionRepository sessionRepository;
    private final UuidHolder uuidHolder;
    private final UserReader userReader;

    public Session append(SessionAppend sessionAppend) {
        User user = userReader.getById(sessionAppend.getUserId());
        Session newSession = Session.of(uuidHolder, user);
        return sessionRepository.save(newSession);
    }
}
