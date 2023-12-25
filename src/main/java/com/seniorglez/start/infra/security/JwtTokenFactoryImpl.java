package com.seniorglez.start.infra.security;

import com.seniorglez.start.domain.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenFactoryImpl implements JwtTokenFactory{
    @Value("${app.security.jwt.secret}")
    private String secret;

    @Value("${app.security.jwt.expiration}")
    private Long expirationTime;

    @Override
    public String createAccessJwtToken(User user) {
        if (user.getUsername().isEmpty()) {
            throw new IllegalArgumentException("No se puede crear un JWT sin username");
        }

        Claims claims = Jwts.claims().setSubject(user.getUsername());

        Date now = new Date();
        Date validity = new Date(now.getTime() + expirationTime);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
