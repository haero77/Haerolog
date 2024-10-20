package com.haerolog.domain.post.repository;

import com.haerolog.domain.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Post> findByUserIdAndDeleted(@Param("userId") Long userId, @Param("deleted") boolean deleted);

    @Query(value = "insert into  Post (userId, title, content, deleted) SELECT :userId, :title, :content, false WHERE NOT EXISTS (SELECT 1 FROM Post WHERE userId = :userId AND deleted = false)", nativeQuery = true)
    int createPostIfNotExists(@Param("userId") Long userId, @Param("title") String title, @Param("content") String content);
}
