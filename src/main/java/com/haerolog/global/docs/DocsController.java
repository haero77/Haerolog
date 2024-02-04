package com.haerolog.global.docs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocsController {

	@GetMapping("/docs")
	public String showApiDocs() {
		return "test/test";
	}

}
