package com.haerolog.domain.user.service;

import com.haerolog.domain.user.infrastructure.persistence.UserEntity;
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

		UserEntity userEntity = super.userJpaRepository.findById(userId).get();
		assertAll(
				() -> assertThat(userEntity.getId()).isEqualTo(userId),
				() -> assertThat(userEntity.getEmail()).isEqualTo("email@gmail.com"),
				() -> assertThat(userEntity.getPassword()).isEqualTo("pw")
		);
	}

}