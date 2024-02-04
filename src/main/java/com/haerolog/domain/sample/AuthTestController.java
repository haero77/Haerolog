package com.haerolog.domain.sample;

import com.haerolog.global.config.auth.data.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthTestController {

	@GetMapping("/foo")
	public String foo(UserSession userSession) {
		log.info(">>> userName={}", userSession.getName());
		return userSession.getName();
	}

	@GetMapping("/bar")
	public String bar() {
		return "노인증";
	}

}
