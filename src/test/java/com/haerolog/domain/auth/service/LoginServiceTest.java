package com.haerolog.domain.auth.service;

import com.haerolog.domain.auth.model.Session;
import com.haerolog.domain.auth.repository.SessionRepository;
import com.haerolog.domain.auth.service.login.LoginRequest;
import com.haerolog.domain.auth.service.login.LoginService;
import com.haerolog.domain.user.model.User;
import com.haerolog.domain.user.repository.UserRepository;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class LoginServiceTest extends IntegrationTestSupport {

    @Autowired
    LoginService sut;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SessionRepository sessionRepository;

    @AfterEach
    void afterEach() {
        userRepository.deleteAllInBatch();
        sessionRepository.deleteAllInBatch();
    }

    @DisplayName("이메일과 비밀번호로 로그인 가능하다.")
    @Test
    void login() {
        // given
        User user = User.builder()
                .name("name")
                .email("email@email.com")
                .password("pw")
                .build();
        userRepository.save(user);

        LoginRequest loginRequest = LoginRequest.builder()
                .email("email@email.com")
                .password("pw")
                .build();

        // when
        sut.login(loginRequest);

        // then
        Session session = sessionRepository.findAll().get(0);
        assertThat(session.getUser().getUserId()).isEqualTo(user.getUserId());
    }

}