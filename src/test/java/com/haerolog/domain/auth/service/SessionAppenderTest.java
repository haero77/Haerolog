package com.haerolog.domain.auth.service;

import com.haerolog.domain.auth.infrastructure.persistence.SessionEntity;
import com.haerolog.domain.auth.service.port.SessionRepository;
import com.haerolog.domain.common.service.port.UuidHolder;
import com.haerolog.mock.FakeUuidHolder;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class SessionAppenderTest extends IntegrationTestSupport {

    @Autowired
    SessionRepository sessionRepository;

    @DisplayName("세션을 추가한다.")
    @Test
    void append() {
        UuidHolder uuidHolder = new FakeUuidHolder("aaa-aaa-aaa-aaa");
        SessionAppender sut = new SessionAppender(sessionRepository, uuidHolder);

        SessionAppend sessionAppend = SessionAppend.builder()
                .userId(1L)
                .build();

        sut.append(sessionAppend);

        SessionEntity sessionEntity = super.sessionJpaRepository.findAll().get(0);
        assertAll(
                () -> assertThat(sessionEntity.getUserId()).isEqualTo(1L),
                () -> assertThat(sessionEntity.getAccessToken()).isEqualTo("aaa-aaa-aaa-aaa")
        );
    }

}