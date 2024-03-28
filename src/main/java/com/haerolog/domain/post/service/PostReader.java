package com.haerolog.domain.post.service;

import com.haerolog.domain.post.exception.PostNotFoundException;
import com.haerolog.domain.post.model.Post;
import com.haerolog.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostReader {

	private final PostRepository postRepository;

	public Post getById(long postId) {
		return postRepository.findById(postId)
				.orElseThrow(PostNotFoundException::new);
	}

}
