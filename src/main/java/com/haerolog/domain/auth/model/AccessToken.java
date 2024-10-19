package com.haerolog.domain.auth.model;

import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public class AccessToken {

    private final String tokenValue;

    public AccessToken(final String tokenValue) {
        Assert.hasText(tokenValue, "tokenValue must not be null");
        this.tokenValue = tokenValue;
    }
}
