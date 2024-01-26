package com.haerolog.domain.post.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.haerolog.domain.post.application.domain.Post;
import com.haerolog.domain.post.repository.PostRepository;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PostRemoverTest extends IntegrationTestSupport {

	@Autowired
	PostRemover sut;

	@Autowired
	PostRepository repository;

	@AfterEach
	void afterEach() {
		repository.deleteAllInBatch();
	}

	@DisplayName("게시글 삭제")
	@Test
	void delete() {
		Post post = Post.builder()
				.title("title")
				.content("content")
				.build();
		repository.save(post);

		sut.remove(post.getId());

		assertThat(repository.count()).isEqualTo(0);
	}

}