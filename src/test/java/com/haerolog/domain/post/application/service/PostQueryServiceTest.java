package com.haerolog.domain.post.application.service;

import com.haerolog.domain.post.repository.PostRepository;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;

class PostQueryServiceTest extends IntegrationTestSupport {

	@Autowired
	PostQueryService sut;

	@Autowired
	PostRepository repository;

	@AfterEach
	void afterEach() {
		repository.deleteAllInBatch();
	}

}