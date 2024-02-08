package com.haerolog.domain.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class GetBodyApi {

	@GetMapping("/api/get-body")
	public ResponseEntity<Void> getBody(@RequestBody @Valid GetBodyDto getBodyDto) {
		log.info(getBodyDto.toString());
		return ResponseEntity.ok().build();
	}

}
