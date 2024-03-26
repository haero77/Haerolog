package com.haerolog.domain.auth.service.port;

import com.haerolog.domain.auth.infrastructure.persistence.SessionEntity;
import com.haerolog.domain.auth.model.Session;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class SessionRepositoryTest extends IntegrationTestSupport {

    @Autowired
    SessionRepository sut;

    @Test
    void findById() {
        // given
        SessionEntity session = SessionEntity.builder()
                .accessToken("accessToken")
                .userId(1L)
                .build();
        super.sessionJpaRepository.save(session);

        // when
        Optional<Session> result = sut.findById(session.getId());


        // then
        assertThat(result).isPresent();
        Session findSession = result.get();
        assertThat(findSession.getAccessToken()).isEqualTo("accessToken");
    }


}