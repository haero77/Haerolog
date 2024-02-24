package com.haerolog.domain.post.application.service;

import com.haerolog.domain.post.application.domain.Post;
import com.haerolog.domain.post.repository.PostRepository;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class PostRemoverTest extends IntegrationTestSupport {

	@Autowired
	PostRemover sut;

	@Autowired
	PostRepository repository;

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