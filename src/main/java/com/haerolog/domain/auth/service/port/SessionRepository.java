package com.haerolog.domain.auth.service.port;

import com.haerolog.domain.auth.model.Session;

import java.util.Optional;

public interface SessionRepository {

    /**
     * @return sessionId
     */
    Long save(Session session);

    Optional<Session> findById(Long sessionId);

}
