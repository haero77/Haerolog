package com.haerolog.domain.common.infrastructure;

import com.haerolog.domain.common.service.port.UuidHolder;

import java.util.UUID;

public class SystemUuidHolder implements UuidHolder {

	@Override
	public UUID random() {
		return UUID.randomUUID();
	}

}
