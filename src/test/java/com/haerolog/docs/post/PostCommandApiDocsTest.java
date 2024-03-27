//package com.haerolog.docs.post;
//
//import com.haerolog.domain.post.service.request.PostAppend;
//import com.haerolog.support.RestDocsSupport;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
//import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
//import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
//import static org.springframework.restdocs.snippet.Attributes.key;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//class PostCommandApiDocsTest extends RestDocsSupport {
//
//	@DisplayName("글 작성")
//	@Test
//	void post_append() throws Exception {
//		// given
//		PostAppend request = PostAppend.builder()
//				.title("sample title")
//				.content("sample content")
//				.build();
//		String json = objectMapper.writeValueAsString(request);
//
//		// expected
//		mockMvc.perform(post("/api/v1/posts")
//						.contentType(APPLICATION_JSON)
//						.content(json)
//						.accept(APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andDo(document("post-append",
//						requestFields(
//								fieldWithPath("title").description("글 제목")
//										.attributes(key("constraint").value("좋은 제목 입력해주세요.")),
//								fieldWithPath("content").description("글 내용").optional()
//						)
//				));
//	}
//
//}