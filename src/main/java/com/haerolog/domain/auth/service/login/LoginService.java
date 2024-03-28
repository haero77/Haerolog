package com.haerolog.domain.auth.service.login;

import com.haerolog.domain.auth.model.Session;
import com.haerolog.domain.auth.service.session.SessionAppend;
import com.haerolog.domain.auth.service.session.SessionAppender;
import com.haerolog.domain.auth.service.session.SessionReader;
import com.haerolog.domain.user.model.User;
import com.haerolog.domain.user.service.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserReader userReader;
	private final SessionAppender sessionAppender;
	private final SessionReader sessionReader;

	/**
	 * @return accessToken
	 */
	public String login(LoginRequest loginRequest) {
		User user = userReader.getBy(loginRequest.toUserEmailPassword());
		Long sessionId = sessionAppender.append(SessionAppend.fromUserId(user.getUserId()));
		Session session = sessionReader.getById(sessionId);
		return session.getAccessToken();
	}

}
