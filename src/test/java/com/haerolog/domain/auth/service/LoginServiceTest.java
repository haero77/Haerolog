package com.haerolog.domain.auth.service;

import com.haerolog.domain.auth.infrastructure.persistence.SessionEntity;
import com.haerolog.domain.user.infrastructure.persistence.UserEntity;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class LoginServiceTest extends IntegrationTestSupport {

    @Autowired
    LoginService sut;

    @DisplayName("이메일과 비밀번호로 로그인 가능하다.")
    @Test
    void login() {
        // given
        UserEntity user = UserEntity.builder()
                .name("name")
                .email("email@email.com")
                .password("pw")
                .build();
        super.userJpaRepository.save(user);

        LoginRequest loginRequest = LoginRequest.builder()
                .email("email@email.com")
                .password("pw")
                .build();

        // when
        sut.login(loginRequest);

        // then
        SessionEntity sessionEntity = super.sessionJpaRepository.findAll().get(0);
        assertThat(sessionEntity.getUserId()).isEqualTo(user.getId());
    }


}