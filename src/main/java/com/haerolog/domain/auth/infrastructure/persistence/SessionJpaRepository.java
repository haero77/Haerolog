package com.haerolog.domain.auth.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionJpaRepository extends JpaRepository<SessionEntity, Long> {

    Optional<SessionEntity> findByAccessToken(String accessToken);

}
