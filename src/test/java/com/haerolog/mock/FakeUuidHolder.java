package com.haerolog.mock;

import com.haerolog.global.service.UuidHolder;

public class FakeUuidHolder implements UuidHolder {

	private final String randomUuid;

	public FakeUuidHolder(String randomUuid) {
		this.randomUuid = randomUuid;
	}

	@Override
	public String random() {
		return this.randomUuid;
	}

}
