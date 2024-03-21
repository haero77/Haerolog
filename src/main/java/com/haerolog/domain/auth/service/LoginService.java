package com.haerolog.domain.auth.service;

import com.haerolog.domain.user.model.User;
import com.haerolog.domain.user.service.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserReader userReader;
	private final SessionAppender sessionAppender;

	public void login(LoginRequest loginRequest) {
		User user = userReader.getBy(loginRequest.toUserEmailPassword());
		sessionAppender.append(SessionAppend.fromUserId(user.getId()));
	}

}
