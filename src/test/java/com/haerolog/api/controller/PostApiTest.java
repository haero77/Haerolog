//package com.haerolog.api.controller;
//
//import com.haerolog.domain.post.infrastructure.repository.PostEntity;
//import com.haerolog.domain.post.service.request.PostCreate;
//import com.haerolog.support.IntegrationTestSupport;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.hamcrest.Matchers.is;
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@AutoConfigureMockMvc
//class PostApiTest extends IntegrationTestSupport {
//
//	@DisplayName("/posts 요청 시 'Hello World' 를 출력한다.")
//	@Test
//	void test() throws Exception {
//		// given
//		PostCreate request = PostCreate.builder()
//				.title("제목입니다.")
//				.content("내용입니다.")
//				.build();
//
//		String json = objectMapper.writeValueAsString(request);
//
//		// expected
//		mockMvc.perform(post("/posts")
//						.contentType(APPLICATION_JSON)
//						.content(json)
//				)
//				.andExpect(status().isOk())
//				.andExpect(content().string(""))
//				.andDo(print()); // summary 출력
//	}
//
//	@DisplayName("POST /posts 요청 시 title 값은 필수다.")
//	@Test
//	void test2() throws Exception {
//		PostCreate request = PostCreate.builder()
//				.title(null)
//				.content("내용입니다.")
//				.build();
//
//		String json = objectMapper.writeValueAsString(request);
//
//		mockMvc.perform(post("/posts")
//						.contentType(APPLICATION_JSON)
//						.content(json)
//				)
//				.andExpect(status().isBadRequest())
//				.andExpect(jsonPath("$.code").value("400"))
//				.andExpect(jsonPath("$.message").value("잘못된 요청입니다."))
//				.andExpect(jsonPath("$.validation.title").value("타이틀을 입력해주세요."))
//				.andDo(print());
//	}
//
//	@DisplayName("/posts 요청 시 DB에 값이 저장된다.")
//	@Test
//	void test3() throws Exception {
//		// given
//		PostCreate request = PostCreate.builder()
//				.title("제목입니다.")
//				.content("내용입니다.")
//				.build();
//
//		String json = objectMapper.writeValueAsString(request);
//
//		// when
//		mockMvc.perform(post("/posts")
//						.contentType(APPLICATION_JSON)
//						.content(json)
//				)
//				.andExpect(status().isOk())
//				.andDo(print());
//
//		// then
//		assertThat(postJpaRepository.count()).isEqualTo(1L);
//
//		PostEntity post = postJpaRepository.findAll().get(0);
//		assertThat(post.getTitle()).isEqualTo("제목입니다.");
//		assertThat(post.getContent()).isEqualTo("내용입니다.");
//	}
//
//	@DisplayName("글 1개 조회")
//	@Test
//	void test4() throws Exception {
//		// given
//		PostEntity post = PostEntity.builder()
//				.title("123456789012345")
//				.content("bar")
//				.build();
//
//		postJpaRepository.save(post);
//
//		// expected
//		mockMvc.perform(get("/posts/{postId}", post.getId())
//						.contentType(APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.id").value(post.getId()))
//				.andExpect(jsonPath("$.title").value("1234567890"))
//				.andExpect(jsonPath("$.content").value("bar"))
//				.andDo(print());
//	}
//
//	/**
//	 * fixme 단독 실행 시 테스트 성공하지만, 여러 개 실행시 실패
//	 * (JPA) id 가 1로 제대로 초기화되지 않는 문제가 있다.
//	 */
//	@DisplayName("글 여러 개 조회")
//	@Test
//	void test5() throws Exception {
//		// given
//		List<PostEntity> requestPosts = IntStream.rangeClosed(1, 20)
//				.mapToObj(i -> PostEntity.builder()
//						.title("제목" + i)
//						.content("컨텐츠" + i)
//						.build())
//				.collect(Collectors.toList());
//		postJpaRepository.saveAll(requestPosts);
//
//		// expected
//		mockMvc.perform(get("/posts?page=1&size=10"))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.length()", is(10)))
//				.andExpect(jsonPath("[0].id").value(requestPosts.get(19).getId()))
//				.andExpect(jsonPath("[9].id").value(requestPosts.get(10).getId()))
//				.andDo(print());
//	}
//
//	@DisplayName("게시글 삭제")
//	@Test
//	void delete_post() throws Exception {
//		// given
//		PostEntity post = PostEntity.builder()
//				.title("title")
//				.content("content")
//				.build();
//		postJpaRepository.save(post);
//
//		// expected
//		mockMvc.perform(delete("/posts/{postId}", post.getId())
//						.contentType(APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andDo(print());
//	}
//
//}