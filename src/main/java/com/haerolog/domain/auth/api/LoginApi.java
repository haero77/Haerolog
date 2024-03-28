package com.haerolog.domain.auth.api;

import com.haerolog.domain.auth.service.login.LoginRequest;
import com.haerolog.domain.auth.service.login.LoginService;
import com.haerolog.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LoginApi {

    private final LoginService loginService;

    /**
     * (호돌맨) auth는 보통 POST로 받음
     */
    @PostMapping("/api/v1/login")
    public ApiResponse<SessionResponse> login(
            @RequestBody @Valid LoginRequest loginRequest
    ) {
        String accessToken = loginService.login(loginRequest);
        SessionResponse response = SessionResponse.fromAccessToken(accessToken);
        return ApiResponse.ok(response);
    }

}
