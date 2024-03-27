package com.haerolog.domain.post.infrastructure.repository;

import com.haerolog.domain.post.model.Post;

import java.util.Optional;

public interface PostRepository {

    Optional<Post> findById(Long postId);

    /**
     * @return postId
     */
    Long save(Post post);

}
