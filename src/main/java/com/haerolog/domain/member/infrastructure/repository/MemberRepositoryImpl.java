package com.haerolog.domain.member.infrastructure.repository;

import com.haerolog.domain.member.infrastructure.mapper.MemberMapper;
import com.haerolog.domain.member.model.Member;
import com.haerolog.domain.member.service.port.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

	private final MemberJpaRepository jpaRepository;
	private final MemberMapper mapper = MemberMapper.INSTANCE;

	@Override
	public Optional<Member> findById(long id) {
		return jpaRepository.findById(id).map(mapper::toModel);
	}

	@Override
	public Long save(Member member) {
		MemberEntity newEntity = jpaRepository.save(mapper.toEntity(member));
		return newEntity.getId();
	}

}
