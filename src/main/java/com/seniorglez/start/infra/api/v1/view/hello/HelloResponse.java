package com.seniorglez.start.infra.api.v1.view.hello;

public class HelloResponse {

    private String response;

    public HelloResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }
}
