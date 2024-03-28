package com.haerolog.domain.auth.service;

import com.haerolog.domain.auth.model.Session;
import com.haerolog.domain.auth.service.login.LoginRequest;
import com.haerolog.domain.auth.service.login.LoginService;
import com.haerolog.domain.user.model.User;
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
    void  login() {
        // given
        User user = User.builder()
                .name("name")
                .email("email@email.com")
                .password("pw")
                .build();
        super.userRepository.save(user);

        LoginRequest loginRequest = LoginRequest.builder()
                .email("email@email.com")
                .password("pw")
                .build();

        // when
        sut.login(loginRequest);

        // then
        Session session = super.sessionRepository.findAll().get(0);
        assertThat(session.getUser().getUserId()).isEqualTo(user.getUserId());
    }


}