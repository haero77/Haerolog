package com.haerolog.domain.auth.infrastructure.persistence;

import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class SessionJpaRepositoryTest extends IntegrationTestSupport {

    @Autowired
    SessionJpaRepository sut;

    @DisplayName("AccessToken으로 Session을 조회 가능하다.")
    @Test
    void findByAccessToken() {
        // given
        SessionEntity sessionEntity = SessionEntity.builder()
                .accessToken("accessToken")
                .build();
        super.sessionJpaRepository.save(sessionEntity);

        // when
        Optional<SessionEntity> result = sut.findByAccessToken("accessToken");

        // then
        assertThat(result).isPresent();
        SessionEntity findSessionEntity = result.get();
        assertThat(findSessionEntity.getAccessToken()).isEqualTo("accessToken");
    }

}