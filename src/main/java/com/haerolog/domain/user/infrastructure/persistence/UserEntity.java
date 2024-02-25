package com.haerolog.domain.user.infrastructure.persistence;

import com.haerolog.domain.common.infrastructure.persistence.BaseTimeEntity;
import com.haerolog.domain.user.model.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "users")
public class UserEntity extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String email;
	private String password;

	@Builder
	private UserEntity(Long id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public static UserEntity from(User user) {
		return UserEntity.builder()
				.id(user.getId())
				.name(user.getName())
				.email(user.getEmail())
				.password(user.getPassword())
				.build();
	}

	public User toModel() {
		return User.builder()
				.id(this.id)
				.name(this.name)
				.email(this.email)
				.password(this.password)
				.build();
	}

}
