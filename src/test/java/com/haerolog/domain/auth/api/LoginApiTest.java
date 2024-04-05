package com.haerolog.domain.auth.api;

import com.haerolog.domain.auth.repository.SessionRepository;
import com.haerolog.domain.auth.service.login.LoginRequest;
import com.haerolog.domain.user.model.User;
import com.haerolog.domain.user.repository.UserRepository;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class LoginApiTest extends IntegrationTestSupport {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SessionRepository sessionRepository;

    @AfterEach
    void afterEach() {
        userRepository.deleteAllInBatch();
        sessionRepository.deleteAllInBatch();
    }

    @Disabled
    @DisplayName("로그인 성공 후 세션을 응답한다.")
    @Test
    void login() throws Exception {
        // given
        userRepository.save(
                User.builder()
                        .email("email@email.com")
                        .password("password")
                        .build()
        );

        LoginRequest loginRequest = LoginRequest.builder()
                .email("email@email.com")
                .password("password")
                .build();
        String json = objectMapper.writeValueAsString(loginRequest);

        // expected
        mockMvc.perform(post("/api/v1/login")
                        .contentType(APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.code").value("200"))
                .andExpect(jsonPath("$.data.accessToken").exists())
                .andDo(print());

        int sessionSize = sessionRepository.findAll().size();
        assertThat(sessionSize).isEqualTo(1);
    }

    @DisplayName("로그인 성공 후 세션이 생성되고, 응답 쿠키에 세션을 포함한다.")
    @Test
    void login_session() throws Exception {
        // given
        userRepository.save(
                User.builder()
                        .email("email@email.com")
                        .password("password")
                        .build()
        );

        LoginRequest loginRequest = LoginRequest.builder()
                .email("email@email.com")
                .password("password")
                .build();

        // expected
        mockMvc.perform(post("/api/v1/login")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest))
                )
                .andExpect(status().isOk())
                .andExpect(cookie().exists("SESSION")) // https://www.tabnine.com/code/java/methods/org.springframework.test.web.servlet.result.MockMvcResultMatchers/cookie
                .andDo(print());

        int sessionSize = sessionRepository.findAll().size();
        assertThat(sessionSize).isEqualTo(1);
    }

}