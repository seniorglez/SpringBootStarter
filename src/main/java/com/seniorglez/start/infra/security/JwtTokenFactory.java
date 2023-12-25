package com.seniorglez.start.infra.security;

import com.seniorglez.start.domain.model.User;

public interface JwtTokenFactory {
    String createAccessJwtToken(User user);
}
