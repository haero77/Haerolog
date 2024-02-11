package com.haerolog.domain.user.infrastructure.mapper;

import com.haerolog.domain.user.domain.User;
import com.haerolog.domain.user.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	UserEntity toEntity(User user);

	User toModel(UserEntity userEntity);

}
