package com.haerolog.domain.sample;

import com.haerolog.global.config.auth.data.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthPracticeController {

	@GetMapping("/foo")
	public Long foo(UserSession userSession) {
		log.info(">>> userName={}", userSession.getId());
		return userSession.getId();
	}

	@GetMapping("/bar")
	public String bar() {
		return "노인증";
	}

}
