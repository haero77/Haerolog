package com.haerolog.domain.user.service;

import com.haerolog.domain.user.model.User;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class UserAppenderTest extends IntegrationTestSupport {

	@Autowired
	private UserAppender sut;

	@DisplayName("User를 추가한다.")
	@Test
	void append() {
		UserAppend userAppend = UserAppend.builder()
				.name("name")
				.email("email@gmail.com")
				.password("pw")
				.build();

		Long userId = sut.append(userAppend);

		User user = super.userRepository.findById(userId).get();
		assertAll(
				() -> assertThat(user.getUserId()).isEqualTo(userId),
				() -> assertThat(user.getEmail()).isEqualTo("email@gmail.com"),
				() -> assertThat(user.getPassword()).isEqualTo("pw")
		);
	}

}