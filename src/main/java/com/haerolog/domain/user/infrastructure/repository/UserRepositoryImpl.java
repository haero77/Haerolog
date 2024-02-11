package com.haerolog.domain.user.infrastructure.repository;

import com.haerolog.domain.user.domain.User;
import com.haerolog.domain.user.infrastructure.entity.UserEntity;
import com.haerolog.domain.user.infrastructure.mapper.UserMapper;
import com.haerolog.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

	private final UserMapper mapper = UserMapper.INSTANCE;
	private final UserJpaRepository userJpaRepository;

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {
		return userJpaRepository.findById(id).map(mapper::toModel);
	}

	@Override
	@Transactional
	public Long save(User user) {
		UserEntity newUserEntity = userJpaRepository.save(mapper.toEntity(user));
		return mapper.toModel(newUserEntity).getId();
	}

}
