package com.seniorglez.start.infra.api.v1.view.login;

import com.seniorglez.start.application.useCase.GetUserByCredentialsInput;

public class LoginRequest {

    private String username;

    private String password;

    public LoginRequest(){}

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public GetUserByCredentialsInput toGetUserByCredentialsInput() {
        return new GetUserByCredentialsInput(username, password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
