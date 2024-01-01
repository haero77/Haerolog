package com.haerolog.domain.post.service.request;

import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
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

}
