package com.haerolog.domain.auth.api;

import com.haerolog.domain.auth.api.request.LoginRequest;
import com.haerolog.domain.user.infrastructure.entity.UserEntity;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AuthApiTest extends IntegrationTestSupport {

	@DisplayName("로그인")
	@Test
	void login() throws Exception {
		// given
		UserEntity user = UserEntity.builder()
				.name("name1")
				.email("email1@gmail.com")
				.password("password1")
				.build();
		super.userJpaRepository.save(user);

		LoginRequest request = LoginRequest.builder()
				.email("email1@gmail.com")
				.password("password1")
				.build();

		String json = objectMapper.writeValueAsString(request);

		// expected
		mockMvc.perform(post("/auth/login")
						.contentType(APPLICATION_JSON)
						.content(json)
				)
				.andExpect(status().isOk())
				.andDo(print());
	}

}