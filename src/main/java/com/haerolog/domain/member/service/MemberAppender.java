package com.haerolog.domain.member.service;

import com.haerolog.domain.member.service.port.MemberRepository;
import com.haerolog.domain.member.service.request.MemberAppend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberAppender {

	private final MemberRepository memberRepository;

	public long append(MemberAppend memberAppend) {
		return memberRepository.save(memberAppend.toModel());
	}

}
