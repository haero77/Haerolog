package com.haerolog.domain.auth.infrastructure.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "session")
public class SessionEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	private String accessToken;

}
