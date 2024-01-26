package com.haerolog.domain.post.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.haerolog.domain.post.application.domain.Post;
import com.haerolog.domain.post.application.service.request.PostSearch;
import com.haerolog.support.IntegrationTestSupport;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PostRepositoryCustomImplTest extends IntegrationTestSupport {

	@Autowired
	PostRepository sut;

	@Test
	void getList() {
		sut.save(createPost("title1", "content1"));
		sut.save(createPost("title2", "content2"));

		PostSearch postSearch = PostSearch.builder()
				.page(1)
				.size(2)
				.build();

		List<Post> actual = sut.getList(postSearch); // 프록시 생성되고, 프록시를 이용하여 getList 실행.

		assertAll(
				() -> assertThat(actual).hasSize(2),
				() -> assertThat(actual.get(0).getTitle()).isEqualTo("title2"),
				() -> assertThat(actual.get(1).getTitle()).isEqualTo("title1")
		);
	}

	public Post createPost(String title, String content) {
		return Post.builder()
				.title(title)
				.content(content)
				.build();
	}

}