package com.haerolog.domain.post.application.service;

import com.haerolog.domain.post.application.domain.Post;
import com.haerolog.domain.post.application.service.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostQueryService {

	private final PostReader reader;

	public PostResponse get(long id) {
		Post post = reader.get(id);

		return PostResponse.builder()
				.id(post.getId())
				.title(post.getTitle())
				.content(post.getContent())
				.build();
	}

}
