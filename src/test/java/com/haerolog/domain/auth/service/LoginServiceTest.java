package com.haerolog.domain.auth.service;

import com.haerolog.domain.auth.service.port.SessionRepository;
import com.haerolog.domain.auth.service.request.UserLogin;
import com.haerolog.domain.common.service.port.UuidHolder;
import com.haerolog.domain.user.service.port.UserRepository;
import com.haerolog.mock.FakeUuidHolder;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class LoginServiceTest extends IntegrationTestSupport {

	@Autowired
	SessionRepository sessionRepository;

	@Autowired
	UserRepository userRepository;

	@DisplayName("유저는 로그인 할 수 있다.")
	@Test
	void login() {
		UserLogin userLogin = UserLogin.builder()
				.email("email@email.com")
				.password("password")
				.build();
		UuidHolder uuidHolder = new FakeUuidHolder("aaa-aaa-aaa-aaa");
		LoginService sut = new LoginService(sessionRepository, uuidHolder);

		LoginResponse result = sut.login(userLogin);

		assertThat(result.getAccessToken()).isEqualTo("aaa-aaa-aaa-aaa");
	}

	@DisplayName("유저는 로그인 할 수 있다.")
	@Test
	void login2() {
		UserLogin userLogin = UserLogin.builder()
				.email("email@email.com")
				.password("password")
				.build();
		UuidHolder uuidHolder = new FakeUuidHolder("aaa-aaa-aaa-aab");
		LoginService sut = new LoginService(sessionRepository, uuidHolder);

		LoginResponse result = sut.login(userLogin);

		assertThat(result.getAccessToken()).isEqualTo("aaa-aaa-aaa-aab");
	}

}