package com.seniorglez.start.infra.api.v1.controller;

import com.seniorglez.start.application.useCase.GetUserByCredentialsUseCase;
import com.seniorglez.start.domain.model.User;
import com.seniorglez.start.infra.api.v1.view.login.LoginRequest;
import com.seniorglez.start.infra.api.v1.view.login.LoginResponse;
import com.seniorglez.start.infra.security.JwtTokenFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

        private final JwtTokenFactory tokenFactory;
        private final GetUserByCredentialsUseCase getUserByCredentialsUseCase;

    public AuthController(JwtTokenFactory tokenFactory, GetUserByCredentialsUseCase getUserByCredentialsUseCase) {
        this.tokenFactory = tokenFactory;
        this.getUserByCredentialsUseCase = getUserByCredentialsUseCase;
    }

    @PostMapping("/login")
        public LoginResponse login(@RequestBody LoginRequest request) {
            try {
                User user = getUserByCredentialsUseCase.execute(request.toGetUserByCredentialsInput());
                String accessToken = tokenFactory.createAccessJwtToken(user);
                return new LoginResponse(accessToken);
            } catch (Exception e) {
                //throw new UnauthorizedException();
            }
            return null;
        }
}
