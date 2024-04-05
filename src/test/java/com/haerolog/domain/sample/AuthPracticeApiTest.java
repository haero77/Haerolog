package com.haerolog.domain.sample;

import com.haerolog.domain.auth.model.Session;
import com.haerolog.domain.auth.repository.SessionRepository;
import com.haerolog.domain.user.model.User;
import com.haerolog.domain.user.repository.UserRepository;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AuthPracticeApiTest extends IntegrationTestSupport {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SessionRepository sessionRepository;

    @AfterEach
    void afterEach() {
        userRepository.deleteAllInBatch();
        sessionRepository.deleteAllInBatch();
    }

    @DisplayName("헤더에 액세스 토큰이 없으면 401을 응답한다.")
    @Test
    void no_access_token() throws Exception {
        // given
        // expected
        mockMvc.perform(get("/foo")
                        .contentType(APPLICATION_JSON)
                )
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.status").value(HttpStatus.UNAUTHORIZED.value()))
                .andDo(print());
    }

    /**
     * (호돌맨) 세션 토큰 발급 API를 호출하여 테스트 하지 않는 이유?
     * -> login API 스펙이 바뀌면 사이드 이펙트가 있을 수 있음.
     */
    @Disabled
    @DisplayName("유효한 액세스 토큰으로 인증 가능하다.")
    @Test
    void foo() throws Exception {
        // given
        User user = User.builder()
                .email("email@email.com")
                .password("password")
                .build();
        userRepository.save(user);

        Session session = Session.builder()
                .accessToken("accessToken")
                .user(user)
                .build();
        sessionRepository.save(session);

        // expected
        mockMvc.perform(get("/foo")
                        .header("Authorization", session.getAccessToken())
                        .contentType(APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("로그인 후 검증되지 않은 세션값으로 권한이 필요한 페이지에 접속할 수 없다.")
    @Test
    void no_access_token_persistence() throws Exception {
        // given
        User user = User.builder()
                .email("email@email.com")
                .password("password")
                .build();
        userRepository.save(user);

        Session session = Session.builder()
                .accessToken("accessToken")
                .user(user)
                .build();
        sessionRepository.save(session);

        // expected
        mockMvc.perform(get("/foo")
                        .header("Authorization", "wrong-accessToken")
                        .contentType(APPLICATION_JSON)
                )
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.status").value(HttpStatus.UNAUTHORIZED.value()))
                .andDo(print());
    }

}