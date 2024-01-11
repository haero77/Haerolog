package com.haerolog.domain.post.repository;

import static com.haerolog.domain.post.domain.QPost.post;

import com.haerolog.domain.post.domain.Post;
import com.haerolog.domain.post.service.request.PostSearch;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
