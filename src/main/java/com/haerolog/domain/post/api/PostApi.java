package com.haerolog.domain.post.api;

import com.haerolog.domain.post.application.service.PostService;
import com.haerolog.domain.post.application.service.request.PostCreate;
import com.haerolog.domain.post.application.service.request.PostSearch;
import com.haerolog.domain.post.application.service.response.PostResponse;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostApi {

	private final PostService postService;

	@PostMapping("/posts")
	public void post(@RequestBody @Valid PostCreate request) {
		postService.write(request);
	}

	@GetMapping("/posts/{postId}")
	public PostResponse get(@PathVariable(name = "postId") Long id) {
		return postService.get(id);
	}

	@GetMapping("/posts")
	public List<PostResponse> getList(@Valid @ModelAttribute PostSearch postSearch) {
		return postService.getList(postSearch);
	}

	@DeleteMapping("/posts/{postId}")
	public void delete(@PathVariable Long postId) {
		postService.delete(postId);
	}

}
