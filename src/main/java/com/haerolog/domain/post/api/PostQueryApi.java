package com.haerolog.domain.post.api;

import com.haerolog.domain.post.application.service.PostQueryService;
import com.haerolog.domain.post.application.service.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostQueryApi {

	private final PostQueryService queryService;

	@GetMapping("/posts/{postId}")
	public PostResponse get(@PathVariable(name = "postId") long id) {
		return queryService.get(id);
	}

}
