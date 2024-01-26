package com.haerolog.domain.post.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.haerolog.domain.post.application.domain.Post;
import com.haerolog.domain.post.application.service.request.PostAppend;
import com.haerolog.domain.post.repository.PostRepository;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PostAppenderTest extends IntegrationTestSupport {

	@Autowired
	PostAppender sut;

	@Autowired
	PostRepository repository;

	@AfterEach
	void afterEach() {
		repository.deleteAllInBatch();
	}

	@DisplayName("글 작성")
	@Test
	void append() {
		// given
		PostAppend postAppend = PostAppend.builder()
				.title("제목")
				.content("내용")
				.build();

		// when
		sut.append(postAppend);

		// then
		assertThat(repository.count()).isEqualTo(1);

		Post post = repository.findAll().get(0);
		assertThat(post.getTitle()).isEqualTo("제목");
		assertThat(post.getContent()).isEqualTo("내용");
	}

}