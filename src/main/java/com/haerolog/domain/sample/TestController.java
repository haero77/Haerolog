package com.haerolog.domain.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

	@GetMapping("/foo")
	public String foo(@RequestAttribute String userName) {
		log.info(">>> userName={}", userName);
		return "foo";
	}

}
