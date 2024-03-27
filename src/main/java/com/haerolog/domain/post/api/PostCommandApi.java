//package com.haerolog.domain.post.api;
//
//import com.haerolog.domain.post.service.PostService;
//import com.haerolog.domain.post.service.request.PostAppend;
//import com.haerolog.domain.post.service.request.PostEdit;
//import javax.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1/posts")
//@RequiredArgsConstructor
//public class PostCommandApi {
//
//	private final PostService service;
//
//	@PostMapping
//	public ResponseEntity<Void> append(@RequestBody @Valid PostAppend request) {
//		request.validate();
//		service.append(request);
//		return ResponseEntity.ok().build();
//	}
//
//	@PatchMapping("/{id}")
//	public ResponseEntity<Void> edit(@PathVariable long id, @RequestBody @Valid PostEdit request) {
//		service.edit(id, request);
//		return ResponseEntity.ok().build();
//	}
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> delete(@PathVariable long id) {
//		service.delete(id);
//		return ResponseEntity.ok().build();
//	}
//
//}
