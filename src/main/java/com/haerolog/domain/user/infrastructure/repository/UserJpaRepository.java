package com.haerolog.domain.user.infrastructure.repository;

import com.haerolog.domain.user.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserJpaRepository extends CrudRepository<UserEntity, Long> {

	Optional<UserEntity> findByEmailAndPassword(String email, String password);

}
