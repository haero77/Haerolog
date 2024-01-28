package com.haerolog.docs;

import com.haerolog.domain.post.application.domain.Post;
import com.haerolog.support.RestDocsSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PostQueryApiDocsTest extends RestDocsSupport {

	@AfterEach
	void afterEach() {
		super.postRepository.deleteAllInBatch();
	}

	@DisplayName("글 단건 조회")
	@Test
	void test1() throws Exception {
		Post post = Post.builder()
				.title("123456789012345")
				.content("content")
				.build();
		postRepository.save(post);

		// expected
		super.mockMvc.perform(get("/api/v1/posts/{postId}", post.getId())
						.contentType(APPLICATION_JSON)
						.accept(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("content"))
				.andDo(document("post-inquiry-single",
						pathParameters(
								parameterWithName("postId").description("게시글 ID")
						),
						responseFields(
								fieldWithPath("id").description("게시글 ID"),
								fieldWithPath("title").description("제목"),
								fieldWithPath("content").description("내용")
						))
				);
	}

}
