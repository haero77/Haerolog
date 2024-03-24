package com.haerolog.global.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ApiResponse<T> {

    private final LocalDateTime timestamp;
    private final HttpStatus status;
    private final String code;
    private final T data;

    @Builder
    private ApiResponse(HttpStatus status, String code, T data) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.code = code;
        this.data = data;
    }

    /**
     * todo 이슈: 생성자를 호출할 때는 ApiResponse<T>, ApiResponse<?>가 가능하고, 빌더를 사용할 때는 ApiResponse<?>만 가능하다.
     * <?> 를 사용할 때는 컨트롤러에서도 <?> 처럼 리턴되기 때문에, 가독성이 떨어짐.
     * 팩토리 메서드에서 바로 생성자를 호출하면 되지만, 기존에 빌더를 생성하는 스타일이 무너지기 때문에 이렇게 한다.
     */
    public static <T> ApiResponse<?> ok(T data) {
//        return new ApiResponse<>(HttpStatus.OK, String.valueOf(HttpStatus.OK), data); // 가능
        return ApiResponse.builder()
                .status(HttpStatus.OK)
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(data)
                .build();
    }

    //    public static ApiResponse<?> created(HttpServletResponse response, String uri) {
//        response.setHeader(HttpHeaders.LOCATION, uri);
//
//        return ApiResponse.builder()
//                .status(HttpStatus.CREATED.value())
//                .build();
//    }

}
