package com.sandip.ecommerce.gateway.security;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter
        extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {

    private final RouteValidator routeValidator;

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {

            if (routeValidator.isSecured.test(
                    exchange.getRequest().getURI().getPath())) {

                if (!exchange.getRequest().getHeaders()
                        .containsKey(HttpHeaders.AUTHORIZATION)) {

                    exchange.getResponse()
                            .setStatusCode(HttpStatus.UNAUTHORIZED);

                    return exchange.getResponse().setComplete();
                }

                String authHeader =
                        exchange.getRequest()
                                .getHeaders()
                                .getFirst(HttpHeaders.AUTHORIZATION);

                if (authHeader != null &&
                        authHeader.startsWith("Bearer ")) {

                    String token =
                            authHeader.substring(7);

                    if (!jwtTokenProvider.validateToken(token)) {

                        exchange.getResponse()
                                .setStatusCode(HttpStatus.UNAUTHORIZED);

                        return exchange.getResponse().setComplete();

                    }

                }

            }

            return chain.filter(exchange);

        };

    }

    public static class Config {

    }

}