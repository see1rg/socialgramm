package com.see1rg.socialgramm.payload.response;

import lombok.Getter;

@Getter
public class InvalidLoginResponse {
    private final String username;
    private final String password;
    private final String INVALID_LOGIN_MESSAGE = "Invalid username or password";

    public InvalidLoginResponse() {
        this.username = INVALID_LOGIN_MESSAGE;
        this.password = INVALID_LOGIN_MESSAGE;
    }
}
