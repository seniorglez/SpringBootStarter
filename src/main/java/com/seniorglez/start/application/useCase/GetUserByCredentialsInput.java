package com.seniorglez.start.application.useCase;

public class GetUserByCredentialsInput {

    private String username;

    private String password;

    public GetUserByCredentialsInput(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
