package com.haerolog.domain.common.infrastructure;

import com.haerolog.domain.common.service.port.UuidHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SystemUuidHolder implements UuidHolder {

	@Override
	public UUID random() {
		return UUID.randomUUID();
	}

}
