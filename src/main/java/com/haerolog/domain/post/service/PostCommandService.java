package com.haerolog.domain.post.service;

import com.haerolog.domain.post.api.PostCreateRequest;
import com.haerolog.domain.post.model.Post;
import com.haerolog.domain.post.repository.PostRepository;
import com.haerolog.domain.post.service.request.PostAppend;
import com.haerolog.domain.user.dto.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PostCommandService {

    private final PostRepository postRepository;

    public void create(PostCreateRequest request, UserId userId) {
        PostAppend append = PostAppend.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .userId(userId)
                .build();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void createPost(final Long userId, final String title, final String content) {
//        postRepository.createPostIfNotExists(userId, title, content);
        final Optional<Post> postOpt = postRepository.findByUserIdAndDeleted(userId, false);

        if (postOpt.isEmpty()) {
            final Post newPost = Post.defaultOf(userId, title, content);
            postRepository.save(newPost);
        }
    }
}
