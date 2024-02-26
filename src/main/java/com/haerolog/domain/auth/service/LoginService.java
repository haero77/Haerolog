package com.haerolog.domain.auth.service;

import com.haerolog.domain.auth.service.port.SessionRepository;
import com.haerolog.domain.auth.service.request.UserLogin;
import com.haerolog.domain.common.service.port.UuidHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

	private final SessionRepository sessionRepository;
	private final UuidHolder uuidHolder;

	public LoginResponse login(UserLogin userLogin) {
		// 세션 생성
		Session.bu
		return new LoginResponse("aaa-aaa-aaa-aaa");
	}

}
