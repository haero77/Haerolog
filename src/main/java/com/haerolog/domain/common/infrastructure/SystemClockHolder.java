package com.haerolog.domain.common.infrastructure;

import com.haerolog.domain.common.service.port.ClockHolder;

import java.time.LocalDateTime;

public class SystemClockHolder implements ClockHolder {

	@Override
	public LocalDateTime now() {
		return LocalDateTime.now();
	}

}
