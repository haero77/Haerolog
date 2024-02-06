package com.haerolog.domain.member.infrastructure.mapper;

import com.haerolog.domain.member.infrastructure.repository.MemberEntity;
import com.haerolog.domain.member.model.Member;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {

	MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

	Member toModel(MemberEntity memberEntity);

	MemberEntity toEntity(Member member);

}
