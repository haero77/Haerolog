package com.haerolog.domain.user.api.command;

import com.haerolog.domain.user.api.command.requset.UserAppendRequest;
import com.haerolog.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserCommandApi {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<Void> append(@RequestBody @Valid UserAppendRequest request) {
		userService.append(request.toUserAppend());
		return ResponseEntity.ok().build();
	}

}
