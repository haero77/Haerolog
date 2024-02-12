package com.haerolog.domain.user.repository;

import com.haerolog.domain.user.domain.User;

import java.util.Optional;

public interface UserRepository {

	Optional<User> findById(Long id);

	Long save(User user);

	Optional<User> findByEmailAndPassword(String email, String password);

}
