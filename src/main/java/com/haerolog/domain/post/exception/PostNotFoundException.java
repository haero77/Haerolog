package com.haerolog.domain.post.exception;

/**
 * 특정한 상황에서만 예외가 발생하므로, 예외 메시지는 테스트에서 검증해줄 필요가 없다.
 * (예외 타입 검증만으로도 검증이 충분하므로)
 */

import com.haerolog.global.error.exception.NotFoundException;

/**
 * status -> 404
 */
public class PostNotFoundException extends NotFoundException {

	public static final String MESSAGE = "존재하지 않는 글입니다.";

	public PostNotFoundException() {
		super(MESSAGE);
	}

}
