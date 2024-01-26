package com.haerolog.domain.post.application.service;

import com.haerolog.domain.post.application.domain.Post;
import com.haerolog.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
@RequiredArgsConstructor
public class PostRemover {

	private final PostReader reader;
	private final PostRepository repository;

	public void remove(long postId) {
		Post post = reader.get(postId);
		repository.delete(post);
	}

}
