package com.haerolog.domain.member.service;

import com.haerolog.domain.member.service.request.MemberAppend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberAppender appender;

	public long append(MemberAppend memberAppend) {
		return appender.append(memberAppend);
	}

}
