package com.haerolog.domain.post.application.service;

import com.haerolog.domain.post.application.domain.Post;
import com.haerolog.domain.post.application.domain.PostEditor.PostEditorBuilder;
import com.haerolog.domain.post.application.service.request.PostEdit;
import com.haerolog.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
@RequiredArgsConstructor
public class PostEditor {

	private final PostReader reader;
	private final PostRepository repository;

	public void edit(Long id, PostEdit postEdit) {
		Post post = reader.get(id);

		PostEditorBuilder editorBuilder = post.toEditor();

		com.haerolog.domain.post.application.domain.PostEditor editor = editorBuilder
				.title(postEdit.getTitle())
				.content(postEdit.getContent())
				.build();

		post.edit(editor);
	}

}
