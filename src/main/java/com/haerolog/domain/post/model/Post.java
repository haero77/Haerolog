package com.haerolog.domain.post.model;

import com.haerolog.global.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "user_id")
    private Long userId;

    private String title;

    @Lob
    private String content;

    private boolean deleted;

    @Builder
    public Post(final Long userId, final String title, final String content, final boolean deleted) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.deleted = deleted;
    }

    public static Post defaultOf(final Long userId, final String title, final String content) {
        return Post.builder()
                .userId(userId)
                .title(title)
                .content(content)
                .deleted(false)
                .build();
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
