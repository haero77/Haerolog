package com.haerolog.domain.post.api;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.haerolog.domain.post.application.service.request.PostCreate;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PostCommandApiTest extends IntegrationTestSupport {

	@AfterEach
	void afterEach() {
		super.postRepository.deleteAllInBatch();
	}

	@DisplayName("글 생성")
	@Test
	void create() throws Exception {
		// given
		PostCreate request = PostCreate.builder()
				.title("title")
				.content("content")
				.build();

		String json = objectMapper.writeValueAsString(request);

		// expected
		mockMvc.perform(post("/api/v1/posts")
						.contentType(APPLICATION_JSON)
						.content(json))
				.andExpect(status().isOk())
				.andDo(print());
	}

	@DisplayName("글 생성 시 title값은 필수다.")
	@Test
	void create_validation_title() throws Exception {
		// given
		PostCreate request = PostCreate.builder()
				.title("")
				.content("content")
				.build();

		String json = objectMapper.writeValueAsString(request);

		// expected
		mockMvc.perform(post("/api/v1/posts")
						.contentType(APPLICATION_JSON)
						.content(json)
				)
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.code").value("400"))
				.andExpect(jsonPath("$.message").value("잘못된 요청입니다."))
				.andExpect(jsonPath("$.validation.title").value("타이틀을 입력해주세요."))
				.andDo(print());
	}

	@DisplayName("글 생성 - 제목에 '바보' 포함 시 에러 발생")
	@Test
	void create_error() throws Exception {
		// given
		PostCreate request = PostCreate.builder()
				.title("바보")
				.content("content")
				.build();

		String json = objectMapper.writeValueAsString(request);

		// expected
		mockMvc.perform(post("/api/v1/posts")
						.contentType(APPLICATION_JSON)
						.content(json))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.validation.title").value("제목에 '바보'가 포함될 수 없습니다."))
				.andDo(print());
	}

}