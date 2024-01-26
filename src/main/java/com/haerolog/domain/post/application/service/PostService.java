package com.haerolog.domain.post.application.service;

import com.haerolog.domain.post.application.domain.Post;
import com.haerolog.domain.post.application.domain.PostEditor;
import com.haerolog.domain.post.application.domain.PostEditor.PostEditorBuilder;
import com.haerolog.domain.post.application.service.request.PostAppend;
import com.haerolog.domain.post.application.service.request.PostCreate;
import com.haerolog.domain.post.application.service.request.PostEdit;
import com.haerolog.domain.post.application.service.request.PostSearch;
import com.haerolog.domain.post.application.service.response.PostResponse;
import com.haerolog.domain.post.repository.PostRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostAppender appender;
    private final PostReader reader;
    private final PostRemover remover;

    public void append(PostAppend append) {
        appender.append(append);
    }

    public void remove(long postId) {
        remover.remove(postId);
    }

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
    }

    public List<PostResponse> getList(PostSearch postSearch) {
        return postRepository.getList(postSearch)
                .stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void edit(Long id, PostEdit postEdit) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));

        PostEditorBuilder editorBuilder = post.toEditor();

        PostEditor editor = editorBuilder
                .title(postEdit.getTitle())
                .content(postEdit.getContent())
                .build();

        post.edit(editor);
    }

    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));

        postRepository.delete(post);
    }

}
