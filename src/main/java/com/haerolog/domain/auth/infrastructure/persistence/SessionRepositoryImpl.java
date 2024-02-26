package com.haerolog.domain.auth.infrastructure.persistence;

import com.haerolog.domain.auth.service.port.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SessionRepositoryImpl implements SessionRepository {

	private final SessionJpaRepository sessionJpaRepository;

}
