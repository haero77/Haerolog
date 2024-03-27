//package com.haerolog.domain.post.api;
//
//import com.haerolog.domain.post.service.PostService;
//import com.haerolog.domain.post.service.request.PostCreate;
//import com.haerolog.domain.post.service.request.PostSearch;
//import com.haerolog.domain.post.service.response.PostResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//public class PostApi {
//
//	private final PostService postService;
//
//	@PostMapping("/posts")
//	public void post(@RequestBody @Valid PostCreate request) {
//		postService.write(request);
//	}
//
//	@GetMapping("/posts/{postId}")
//	public PostResponse get(@PathVariable(name = "postId") Long id) {
//		return postService.get(id);
//	}
//
//	@GetMapping("/posts")
//	public List<PostResponse> getList(@Valid @ModelAttribute PostSearch postSearch) {
//		return postService.getList(postSearch);
//	}
//
//	@DeleteMapping("/posts/{postId}")
//	public void delete(@PathVariable Long postId) {
//		postService.delete(postId);
//	}
//
//}
