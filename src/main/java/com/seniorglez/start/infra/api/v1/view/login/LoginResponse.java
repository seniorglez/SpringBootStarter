package com.seniorglez.start.infra.api.v1.view.login;

public class LoginResponse {

    private String accessToken;
    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
