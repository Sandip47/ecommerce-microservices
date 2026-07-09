package com.sandip.ecommerce.gateway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private final String SECRET_KEY =
            "SandipEnterpriseMicroservicesSecretKey2026";

    public boolean validateToken(String token) {

        try {

            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY.getBytes())
                    .build()
                    .parseClaimsJws(token);

            return true;

        } catch (Exception ex) {

            return false;

        }

    }

    public String getUsername(String token) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();

    }

}