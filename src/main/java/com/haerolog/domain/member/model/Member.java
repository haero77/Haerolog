package com.haerolog.domain.member.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {

	private final Long id;
	private final String name;

	@Builder
	private Member(Long id, String name) {
		this.id = id;
		this.name = name;
	}

}
