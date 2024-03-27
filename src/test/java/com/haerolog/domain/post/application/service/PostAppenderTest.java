//package com.haerolog.domain.post.application.service;
//
//import com.haerolog.domain.post.infrastructure.repository.PostEntity;
//import com.haerolog.domain.post.service.PostAppender;
//import com.haerolog.domain.post.service.request.PostAppend;
//import com.haerolog.support.IntegrationTestSupport;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class PostAppenderTest extends IntegrationTestSupport {
//
//	@Autowired
//    PostAppender sut;
//
//	@Autowired
//	PostRepository repository;
//
//	@DisplayName("글 작성")
//	@Test
//	void append() {
//		// given
//		PostAppend postAppend = PostAppend.builder()
//				.title("제목")
//				.content("내용")
//				.build();
//
//		// when
//		sut.append(postAppend);
//
//		// then
//		assertThat(repository.count()).isEqualTo(1);
//
//		PostEntity post = repository.findAll().get(0);
//		assertThat(post.getTitle()).isEqualTo("제목");
//		assertThat(post.getContent()).isEqualTo("내용");
//	}
//
//}