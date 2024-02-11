package com.haerolog.domain.member.infrastructure.repository;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "member")
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	protected MemberEntity() {
	}

	@Builder
	private MemberEntity(Long id, String name) {
		this.id = id;
		this.name = name;
	}

}
