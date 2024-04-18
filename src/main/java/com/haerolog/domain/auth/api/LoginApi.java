package com.haerolog.domain.auth.api;

import com.haerolog.domain.auth.service.login.LoginRequest;
import com.haerolog.domain.auth.service.login.LoginService;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import javax.validation.Valid;
import java.time.Duration;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginApi {

    private final LoginService loginService;

    /**
     * (호돌맨) auth는 보통 POST로 받음
     */
    @PostMapping("/api/v1/login")
    public ResponseEntity<Object> login(
            @RequestBody @Valid LoginRequest loginRequest
    ) {
        String accessToken = loginService.login(loginRequest);

        // todo 호돌맨: secure, httpOnly sameSite 왜 쓰는지
        ResponseCookie cookie = ResponseCookie.from("SESSION", accessToken)
                .domain("localhost") // todo 서버 환경에 따른 분리 필요. (호돌맨: todo 잘 쓰지는 않지만 가끔 쓰긴 한다.)
                .path("/")
                .httpOnly(true)
                .secure(false)
                .maxAge(Duration.ofDays(30))
                .sameSite("Strict")
                .build();

        log.info(">>>>>>>> cookie={}", cookie.toString());

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .build();
    }

    @PostMapping("/api/v1/login/jwt")
    public ResponseEntity<Object> loginJwt(
    ) {
        SecretKey secretKey = Jwts.SIG.HS256.key().build();

        String jws = Jwts.builder() // Jwts(=JWT Signature)
                .subject("Joe")
                .signWith(secretKey)
                .compact();

        ResponseCookie responseCookie = ResponseCookie.from("accessToken", jws)
                .domain("localhost") // todo 서버 환경에 따른 분리 필요.
                .path("/")
                .httpOnly(true)
                .secure(false)
                .maxAge(Duration.ofMinutes(10))
                .sameSite("Strict")
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .build();
    }

}
