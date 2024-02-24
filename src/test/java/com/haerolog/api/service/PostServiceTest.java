package com.haerolog.api.service;

import com.haerolog.domain.post.application.domain.Post;
import com.haerolog.domain.post.application.service.PostService;
import com.haerolog.domain.post.application.service.request.PostCreate;
import com.haerolog.domain.post.application.service.request.PostEdit;
import com.haerolog.domain.post.application.service.request.PostSearch;
import com.haerolog.domain.post.application.service.response.PostResponse;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
class PostServiceTest extends IntegrationTestSupport {

	@Autowired
	PostService sut;

	@DisplayName("글 작성")
	@Test
	void test1() {
		// given
		PostCreate postCreate = PostCreate.builder()
				.title("제목")
				.content("내용")
				.build();

		// when
		sut.write(postCreate);

		// then
		assertThat(postRepository.count()).isEqualTo(1);

		Post post = postRepository.findAll().get(0);
		assertThat(post.getTitle()).isEqualTo("제목");
		assertThat(post.getContent()).isEqualTo("내용");
	}

	@DisplayName("글 1개 조회")
	@Test
	void test2() {
		// given
		Post requestPost = Post.builder()
				.title("123456789012345")
				.content("content")
				.build();
		postRepository.save(requestPost);

		// when
		PostResponse response = sut.get(requestPost.getId());

		// then
		assertThat(response).isNotNull();
		assertThat(response.getTitle()).isEqualTo("1234567890");
		assertThat(response.getContent()).isEqualTo("content");
	}

	@DisplayName("글 여러개 조회")
	@Test
	void getList() {
		List<Post> posts = IntStream.rangeClosed(1, 20) // for int i = 1 to 20
				.mapToObj(i -> Post.builder()
						.title("제목" + i)
						.content("컨텐츠" + i)
						.build())
				.collect(Collectors.toList());
		postRepository.saveAll(posts);

		PostSearch postSearch = PostSearch.builder()
				.page(1)
				.build();

		List<PostResponse> actual = sut.getList(postSearch);

		assertAll(
				() -> assertThat(actual).hasSize(20),
				() -> assertThat(actual.get(0).getTitle()).isEqualTo("제목20"),
				() -> assertThat(actual.get(9).getTitle()).isEqualTo("제목11")
		);
	}

	@DisplayName("글 내용 수정")
	@Test
	void test5() {
		// given
		Post post = Post.builder()
				.title("title")
				.content("content")
				.build();
		postRepository.save(post);

		PostEdit postEdit = PostEdit.builder()
				.title("title")
				.content("changed-content")
				.build();

		// when
		sut.edit(post.getId(), postEdit);

		// then
		Post changedPost = postRepository.findById(post.getId())
				.orElseThrow(() -> new RuntimeException("글이 존재하지 않습니다. id=" + post.getId()));

		assertAll(
				() -> assertThat(changedPost.getTitle()).isEqualTo("title"),
				() -> assertThat(changedPost.getContent()).isEqualTo("changed-content")
		);
	}

	@DisplayName("글 내용 수정 - 제목이 주어지지 않은 경우")
	@Test
	void post_edit_no_title() {
		// given
		Post post = Post.builder()
				.title("title")
				.content("content")
				.build();
		postRepository.save(post);

		PostEdit postEdit = PostEdit.builder()
				.content("changed-content")
				.build();

		// when
		sut.edit(post.getId(), postEdit);

		// then
		Post changedPost = postRepository.findById(post.getId())
				.orElseThrow(() -> new RuntimeException("글이 존재하지 않습니다. id=" + post.getId()));

		assertAll(
				() -> assertThat(changedPost.getTitle()).isEqualTo("title"),
				() -> assertThat(changedPost.getContent()).isEqualTo("changed-content")
		);
	}

	@DisplayName("게시글 삭제")
	@Test
	void delete() {
		Post post = Post.builder()
				.title("title")
				.content("content")
				.build();
		postRepository.save(post);

		sut.delete(post.getId());

		assertThat(postRepository.count()).isEqualTo(0);
	}

}