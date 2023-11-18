package com.haerolog.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String content;

    @Builder
    private Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /**
     * 엔티티에 getter 메서드를 만들 때는 서비스의 정책을 절대 넣지 마라. (다른 정책과 충돌 발생가능)
     */
//    public String getTitle() {
//        return title.substring(0, 10);
//    }

}
