//package com.haerolog.domain.post.application.service;
//
//import com.haerolog.domain.post.infrastructure.repository.PostEntity;
//import com.haerolog.domain.post.service.request.PostEdit;
//import com.haerolog.support.IntegrationTestSupport;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertAll;
//
//class PostEditorTest extends IntegrationTestSupport {
//
//	@Autowired
//    PostEditor sut;
//
//	@Autowired
//	PostRepository repository;
//
//	@DisplayName("글 내용 수정")
//	@Test
//	void test5() {
//		// given
//		PostEntity post = PostEntity.builder()
//				.title("title")
//				.content("content")
//				.build();
//		repository.save(post);
//
//		PostEdit postEdit = PostEdit.builder()
//				.title("title")
//				.content("changed-content")
//				.build();
//
//		// when
//		sut.edit(post.getId(), postEdit);
//
//		// then
//		PostEntity changedPost = repository.findById(post.getId())
//				.orElseThrow(() -> new RuntimeException("글이 존재하지 않습니다. id=" + post.getId()));
//
//		assertAll(
//				() -> assertThat(changedPost.getTitle()).isEqualTo("title"),
//				() -> assertThat(changedPost.getContent()).isEqualTo("changed-content")
//		);
//	}
//
//	@DisplayName("글 내용 수정 - 제목이 주어지지 않은 경우")
//	@Test
//	void post_edit_no_title() {
//		// given
//		PostEntity post = PostEntity.builder()
//				.title("title")
//				.content("content")
//				.build();
//		repository.save(post);
//
//		PostEdit postEdit = PostEdit.builder()
//				.content("changed-content")
//				.build();
//
//		// when
//		sut.edit(post.getId(), postEdit);
//
//		// then
//		PostEntity changedPost = repository.findById(post.getId())
//				.orElseThrow(() -> new RuntimeException("글이 존재하지 않습니다. id=" + post.getId()));
//
//		assertAll(
//				() -> assertThat(changedPost.getTitle()).isEqualTo("title"),
//				() -> assertThat(changedPost.getContent()).isEqualTo("changed-content")
//		);
//	}
//
//}