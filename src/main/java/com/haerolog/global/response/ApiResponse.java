package com.haerolog.global.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

@Getter
public class ApiResponse<T> {

	private final int code;
	private final T data;

	@Builder
	private ApiResponse(HttpStatus status, T data) {
		this.code = status.value();
		this.data = data;
	}

	public static <T> ApiResponse<?> ok(T data) {
		return ApiResponse.builder()
				.status(HttpStatus.OK)
				.data(data)
				.build();
	}

	public static ApiResponse<?> created(HttpServletResponse response, String uri) {
		response.setHeader(HttpHeaders.LOCATION, uri);

		return ApiResponse.builder()
				.status(HttpStatus.CREATED)
				.build();
	}

}
