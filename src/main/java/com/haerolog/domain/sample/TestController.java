package com.haerolog.domain.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/foo")
	public String foo() {
		return "foo";
	}

}
