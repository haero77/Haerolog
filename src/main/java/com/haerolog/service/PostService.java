package com.haerolog.service;

import com.haerolog.domain.Post;
import com.haerolog.repository.PostRepository;
import com.haerolog.request.PostCreate;
import com.haerolog.response.PostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void write(PostCreate postCreate) {
        Post post = Post.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build();

        postRepository.save(post);
    }

    public PostResponse get(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));

        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();

        /**
         * 호돌맨은 웹서비스랑 서비스 두 개로 나눈다.
         * Controller -> WebService -> Repository
         * Controller -> Service -> Repository
         *
         * - 리스폰스 클래스로 나누는, 리스폰스를 위해서 뭔가 해우이를 하는 그런 서비스 -> WebService : (예: PostWebService)
         * - 외부와 연동을 하는, 다른 서비스와 통신을 하기 위해 만드는 서비스는 다 그냥 Service -> (예: PostService)
         * - 근데 지금은 개발을 혼자하고 있어서 PostService 에 다 넣어서 하고 있긴 함.
         */
    }

}
