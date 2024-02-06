package com.haerolog.domain.member.service.port;

import com.haerolog.domain.member.model.Member;

import java.util.Optional;

public interface MemberRepository {

	Optional<Member> findById(long id);

	Long save(Member member);

}
