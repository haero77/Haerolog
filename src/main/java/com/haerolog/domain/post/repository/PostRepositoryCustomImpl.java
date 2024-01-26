package com.haerolog.domain.post.repository;


import com.haerolog.domain.post.application.domain.Post;
import com.haerolog.domain.post.application.service.request.PostSearch;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.haerolog.domain.post.application.domain.QPost.post;


@Repository
@RequiredArgsConstructor
public class PostRepositoryCustomImpl implements PostRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<Post> getList(PostSearch postSearch) {
		return queryFactory
				.selectFrom(post)
				.limit(postSearch.getSize())
				.offset(postSearch.getOffset())
				.orderBy(post.id.desc())
				.fetch();
	}

}
