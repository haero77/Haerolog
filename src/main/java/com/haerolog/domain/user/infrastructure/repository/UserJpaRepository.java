package com.haerolog.domain.user.infrastructure.repository;

import com.haerolog.domain.user.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserJpaRepository extends CrudRepository<UserEntity, Long> {

}
