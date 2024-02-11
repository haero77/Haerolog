package com.haerolog.domain.user.domain;

import com.haerolog.domain.user.exception.UserNotFound;
import com.haerolog.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserReader {

	private final UserRepository userRepository;

	public User getById(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new UserNotFound(userId));
	}

}
