package com.haerolog.domain.auth.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionJpaRepository extends JpaRepository<SessionEntity, Long> {

}
