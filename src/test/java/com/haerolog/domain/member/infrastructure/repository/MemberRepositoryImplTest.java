package com.haerolog.domain.member.infrastructure.repository;

import com.haerolog.domain.member.model.Member;
import com.haerolog.support.IntegrationTestSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryImplTest extends IntegrationTestSupport {

	@AfterEach
	void afterEach() {
		super.memberJpaRepository.deleteAllInBatch();
	}

	@Autowired
	private MemberRepositoryImpl sut;

	@Test
	void save() {
		Member member = Member.builder().name("name").build();

		Long actual = sut.save(member);

		assertThat(actual).isNotNull();
	}

}