package com.haerolog.mock;

import com.haerolog.domain.common.service.port.UuidHolder;

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
