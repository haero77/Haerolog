package com.haerolog.domain.post.api;

import com.haerolog.domain.post.service.PostCommandService;
import com.haerolog.global.config.auth.data.UserSession;
import com.haerolog.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostCommandApi {

    private final PostCommandService postCommandService;

    @PostMapping("/api/v1/posts")
    public ApiResponse<Void> create(@RequestBody PostCreateRequest request, UserSession userSession) {
        postCommandService.create(request, userSession.fetchUserId());
    }

//	@PostMapping
//	public ResponseEntity<Void> append(@RequestBody @Valid PostAppend request) {
//		request.validate();
//		postService.append(request);
//		return ResponseEntity.ok().build();
//	}
//
//	@PatchMapping("/{id}")
//	public ResponseEntity<Void> edit(@PathVariable long id, @RequestBody @Valid PostEdit request) {
//		postService.edit(id, request);
//		return ResponseEntity.ok().build();
//	}
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> delete(@PathVariable long id) {
//		postService.delete(id);
//		return ResponseEntity.ok().build();
//	}

}
