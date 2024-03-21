package com.haerolog.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserEmailPassword {

    private final String email;
    private final String password;

    @Builder
    private UserEmailPassword(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
