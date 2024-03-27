package com.haerolog.domain.post.service;

import com.haerolog.domain.post.exception.PostNotFoundException;
import com.haerolog.domain.post.infrastructure.repository.PostRepository;
import com.haerolog.domain.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostReader {

	private final PostRepository postRepository;

	public Post getById(long id) {
		return postRepository.findById(id).orElseThrow(PostNotFoundException::new);
	}

}
