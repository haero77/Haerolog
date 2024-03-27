package com.haerolog.domain.post.infrastructure.repository;

import com.haerolog.domain.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final PostJpaRepository postJpaRepository;

    @Override
    public Optional<Post> findById(Long postId) {
        return postJpaRepository.findById(postId).map(PostEntity::toModel);
    }

    @Override
    public Long save(Post post) {
        PostEntity postEntity = PostEntity.fromModel(post);
        PostEntity saved = postJpaRepository.save(postEntity);
        return saved.getId();
    }

}
