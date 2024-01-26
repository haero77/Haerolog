package com.haerolog.domain.post.application.service.request;

import static java.lang.Math.max;
import static java.lang.Math.min;

import javax.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 나중에 요구사항(정렬, 검색 옵션 등)이 추가될 수 있으므로 Pageable이 아닌 커스텀 Request 사용
 */
@Getter
@ToString
@Builder
public class PostSearch {

    private static final int MAX_SIZE = 2000;

    @Builder.Default
    private Integer page = 1;

    @Builder.Default
    @Min(value = 1, message = "Min size is 1")
    private Integer size = 20; // 조회 개수 정책은 잘 바뀌지 않으므로 default 값 지정

    public long getOffset() {
        return (long) (max(1, page) - 1) * min(size, MAX_SIZE); // 1 페이지부터 시작
    }

}
