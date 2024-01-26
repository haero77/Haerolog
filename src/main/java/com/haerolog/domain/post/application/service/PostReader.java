package com.haerolog.domain.post.application.service;

import com.haerolog.domain.post.application.domain.Post;
import com.haerolog.domain.post.exception.PostNotFoundException;
import com.haerolog.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostReader {

	private final PostRepository postRepository;

	public Post get(long id) {
		return postRepository.findById(id)
				.orElseThrow(PostNotFoundException::new);
	}

}
