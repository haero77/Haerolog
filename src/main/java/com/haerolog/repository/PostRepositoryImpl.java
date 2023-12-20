package com.haerolog.repository;

import com.haerolog.domain.Post;
import com.haerolog.domain.QPost;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Post> getList(int page) {
        return queryFactory
                .selectFrom(QPost.post)
                .limit(10)
                .offset((page - 1) * 10L) // 3 페이지면 앞에 20개를 건너띄고 그 다음 10개를 가져온다.
                .fetch();
    }

}
