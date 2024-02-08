package com.haerolog.domain.sample;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class GetBodyDto {

	@NotBlank
	private String name;

	@Override
	public String toString() {
		return "GetBodyDto{" +
				"name='" + name + '\'' +
				'}';
	}

}
