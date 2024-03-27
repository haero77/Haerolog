package com.haerolog.domain.post.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {


//    private final PostRepository postRepository;
//
//    public void write(PostCreate postCreate) {
//        PostEntity post = PostEntity.builder()
//                .title(postCreate.getTitle())
//                .content(postCreate.getContent())
//                .build();
//
//        postRepository.save(post);
//    }
//
//    public PostResponse get(Long id) {
//        PostEntity post = postRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));
//
//        return PostResponse.builder()
//                .id(post.getId())
//                .title(post.getTitle())
//                .content(post.getContent())
//                .build();
//    }
//
//    public List<PostResponse> getList(PostSearch postSearch) {
//        return postRepository.getList(postSearch)
//                .stream()
//                .map(PostResponse::new)
//                .collect(Collectors.toList());
//    }
//
//    @Transactional
//    public void edit(Long id, PostEdit postEdit) {
//        PostEntity post = postRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));
//
//        PostEditorBuilder editorBuilder = post.toEditor();
//
//        PostEditor editor = editorBuilder
//                .title(postEdit.getTitle())
//                .content(postEdit.getContent())
//                .build();
//
//        post.edit(editor);
//    }
//
//    public void delete(Long id) {
//        PostEntity post = postRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));
//
//        postRepository.delete(post);
//    }

}
