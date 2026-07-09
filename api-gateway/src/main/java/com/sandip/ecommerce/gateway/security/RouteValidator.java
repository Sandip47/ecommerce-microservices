package com.sandip.ecommerce.gateway.security;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> OPEN_API_ENDPOINTS = List.of(

            "/api/auth/login",
            "/api/auth/register",
            "/api/auth/refresh-token",
            "/actuator",
            "/actuator/**"

    );

    public Predicate<String> isSecured =
            uri -> OPEN_API_ENDPOINTS
                    .stream()
                    .noneMatch(uri::startsWith);

}