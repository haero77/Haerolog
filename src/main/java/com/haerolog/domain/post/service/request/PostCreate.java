package com.haerolog.domain.post.service.request;

import com.haerolog.domain.post.infrastructure.repository.PostEntity;
import com.haerolog.global.error.exception.InvalidRequestException;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class PostCreate {

    @NotBlank(message = "타이틀을 입력해주세요.")
    private String title;

    @NotBlank(message = "콘텐츠를 입력해주세요.")
    private String content;

    private PostCreate() {
    }

    @Builder
    private PostCreate(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void validate() {
        if (title.contains("바보")) {
            throw new InvalidRequestException("title", "제목에 '바보'가 포함될 수 없습니다.");
        }
    }

    public PostEntity toEntity() {
        return PostEntity.builder()
                .title(title)
                .content(content)
                .build();
    }

}
