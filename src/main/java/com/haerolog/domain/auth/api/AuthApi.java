package com.haerolog.domain.auth.api;

import com.haerolog.domain.auth.api.request.LoginRequest;
import com.haerolog.domain.auth.exception.InvalidLogInformation;
import com.haerolog.domain.user.model.User;
import com.haerolog.domain.user.service.port.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthApi {

	private final UserRepository userRepository;

	// auth 보통 post 로 받음
	@PostMapping("/auth/login")
	public ResponseEntity<Object> logIn(@RequestBody LoginRequest request) {
		log.info("loginRequest={}", request);

		// db에서 조회
		User user = userRepository.findByEmailAndPassword(request.getEmail(), request.getPassword())
				.orElseThrow(InvalidLogInformation::new);

		// 토큰을 응답
		return ResponseEntity.ok().build();
	}

}
