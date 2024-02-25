package com.haerolog.domain.user.service.port;

import com.haerolog.domain.user.model.User;

import java.util.Optional;

public interface UserRepository {

	Optional<User> findById(Long id);

	Long save(User user);

	Optional<User> findByEmailAndPassword(String email, String password);

}
