package com.haerolog.domain.post.infrastructure.repository;

import com.haerolog.domain.post.application.domain.PostEditor;
import com.haerolog.domain.post.model.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "post")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String content;

    @Builder
    private PostEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static PostEntity fromModel(Post post) {
        return PostEntity.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    public Post toModel() {
        return Post.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .build();
    }

    public PostEditor.PostEditorBuilder toEditor() {
        return PostEditor.builder()
                .title(this.title)
                .content(this.content);
    }

    public void edit(PostEditor editor) {
        this.title = editor.getTitle();
        this.content = editor.getContent();
    }

}
