package com.haerolog.domain.auth.service;

import com.haerolog.domain.user.dto.UserEmailPassword;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class LoginRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public LoginRequest() {
    }

    @Builder
    private LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserEmailPassword toUserEmailPassword() {
        return UserEmailPassword.builder()
                .email(email)
                .password(password)
                .build();
    }

}
