package com.haerolog.domain.user.service;

import com.haerolog.domain.user.dto.UserEmailPassword;
import com.haerolog.domain.user.exception.UserNotFoundExcpetion;
import com.haerolog.domain.user.model.User;
import com.haerolog.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserReader {

	private final UserRepository userRepository;

	public User getById(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundExcpetion(userId));
	}

	public User getBy(UserEmailPassword userEmailPassword) {
		return userRepository.findByEmailAndPassword(userEmailPassword.getEmail(), userEmailPassword.getPassword())
				.orElseThrow(() -> new UserNotFoundExcpetion("Cannot Find User"));
	}

}
