package com.haerolog.domain.auth.infrastructure.persistence;

import com.haerolog.domain.auth.model.Session;
import com.haerolog.domain.auth.service.port.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SessionRepositoryImpl implements SessionRepository {

    private final SessionJpaRepository sessionJpaRepository;

    @Override
    public Long save(Session session) {
        SessionEntity sessionEntity = sessionJpaRepository.save(SessionEntity.fromModel(session));
        return sessionEntity.getId();
    }

    @Override
    public Optional<Session> findById(Long sessionId) {
        return sessionJpaRepository.findById(sessionId)
                .map(SessionEntity::toModel);
    }

}
