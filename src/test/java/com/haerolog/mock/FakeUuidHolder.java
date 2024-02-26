package com.haerolog.mock;

import com.haerolog.domain.common.service.port.UuidHolder;

import java.util.UUID;

public class FakeUuidHolder implements UuidHolder {

	private final String randomUuid;

	public FakeUuidHolder(String randomUuid) {
		this.randomUuid = randomUuid;
	}

	@Override
	public UUID random() {
		return UUID.fromString(this.randomUuid);
	}

}
