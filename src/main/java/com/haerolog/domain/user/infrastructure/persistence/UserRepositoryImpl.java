package com.haerolog.domain.user.infrastructure.persistence;

import com.haerolog.domain.user.model.User;
import com.haerolog.domain.user.service.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

	private final UserJpaRepository userJpaRepository;

	@Override
	public Optional<User> findById(Long id) {
		return userJpaRepository.findById(id).map(UserEntity::toModel);
	}

	@Override
	public Long save(User user) {
		UserEntity newUserEntity = userJpaRepository.save(UserEntity.from(user));
		return newUserEntity.getId();
	}

	@Override
	public Optional<User> findByEmailAndPassword(String email, String password) {
		return userJpaRepository.findByEmailAndPassword(email, password).map(UserEntity::toModel);
	}

}
