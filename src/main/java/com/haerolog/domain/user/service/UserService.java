package com.haerolog.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserAppender userAppender;

	public void append(UserAppend userAppend) {
		userAppender.append(userAppend);
	}

}
