package com.haerolog.domain.post.service.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class PostEdit {

    @NotBlank(message = "타이틀을 입력해주세요.")
    private String title;

    @NotBlank(message = "콘텐츠를 입력해주세요.")
    private String content;

    public PostEdit() {
    }

    @Builder
    private PostEdit(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
