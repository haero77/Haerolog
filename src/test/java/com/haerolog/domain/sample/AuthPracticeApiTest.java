package com.haerolog.domain.sample;

import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AuthPracticeApiTest extends IntegrationTestSupport {

    /**
     * (호돌맨) 세션 토큰 발급 API를 호출하여 테스트 하지 않는 이유?
     * -> login API 스펙이 바뀌면 사이드 이펙트가 있을 수 있음.
     */
    @DisplayName("/foo")
    @Test
    void foo() throws Exception {
        // given


        // expected
        mockMvc.perform(get("/foo")
                        .contentType(APPLICATION_JSON)
                )
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.status").value(HttpStatus.UNAUTHORIZED.value()))
                .andDo(print());
    }

}