package com.haerolog.domain.member.service.request;

import com.haerolog.domain.member.model.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberAppend {

	private final String name;

	@Builder
	private MemberAppend(String name) {
		this.name = name;
	}

	public Member toModel() {
		return Member.builder()
				.name(this.name)
				.build();
	}

}
