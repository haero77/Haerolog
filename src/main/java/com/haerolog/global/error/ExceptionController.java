package com.haerolog.global.error;

import com.haerolog.domain.post.exception.HaerologException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

	/**
	 * 스프링에서 제공하는 MethodArgumentNotValidException, BindException 등은
	 * HaerologException 처럼 비즈니스 익셉션으로 처리하지 않고 따로 만들어둔다.
	 * 이유: 이 안에서 처리해야할 내용이 익셉션 종류마다 조금씩 다르기 때문.
	 * -> 비즈니스 익셉션의 경우 ErrorResponse 하나로 일관되게 나가기 때문에 일관적으로 처리.
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	public ErrorResponse invalidRequestHandler(BindException e) {
		log.info("{}", e.toString());
		return ErrorResponse.badRequest(e.getFieldErrors());
	}

	@ExceptionHandler(HaerologException.class)
	public ResponseEntity<ErrorResponse> handelHaerologException(HaerologException e) {
		return ResponseEntity
				.status(e.getStatusCode())
				.body(ErrorResponse.of(String.valueOf(e.getStatusCode()), e.getMessage()));
	}

}
