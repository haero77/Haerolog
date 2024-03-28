package com.haerolog.domain.user.service;

import com.haerolog.domain.user.model.User;
import com.haerolog.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAppender {

	private final UserRepository userRepository;

	public Long append(UserAppend userAppend) {
		User savedUser = userRepository.save(userAppend.toUser());
		return savedUser.getUserId();
	}

}
