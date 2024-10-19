package com.haerolog.domain.post.service;

import com.haerolog.domain.post.repository.PostRepository;
import com.haerolog.domain.post.service.request.PostAppend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
@RequiredArgsConstructor
public class PostAppender {

	private final PostRepository postRepository;

//	public void append(PostAppend postAppend) {
//		postRepository.save(postAppend.toPost());
//	}

}
