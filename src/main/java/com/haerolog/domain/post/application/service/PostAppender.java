package com.haerolog.domain.post.application.service;

import com.haerolog.domain.post.application.service.request.PostAppend;
import com.haerolog.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
@RequiredArgsConstructor
public class PostAppender {

	private final PostRepository repository;

	public void append(PostAppend append) {
		repository.save(append.toEntity());
	}

}
