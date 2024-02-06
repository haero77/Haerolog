package com.haerolog.domain.member.api.request;

import com.haerolog.domain.member.service.request.MemberAppend;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class MemberAppendRequest {

	@NotBlank
	private String name;

	public MemberAppendRequest() {
	}

	public MemberAppend toServiceRequest() {
		return MemberAppend.builder()
				.name(this.name)
				.build();
	}

}
