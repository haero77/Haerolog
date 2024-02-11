package com.haerolog.domain.user.domain;

import com.haerolog.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAppender {

	private final UserRepository userRepository;

	public Long append(UserAppend userAppend) {
		return userRepository.save(userAppend.toModel());
	}

}
