package com.sandip.ecommerce.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {

        return builder.routes()

                .route("auth-service",
                        r -> r.path("/api/auth/**")
                                .uri("lb://AUTH-SERVICE"))

                .route("user-service",
                        r -> r.path("/api/users/**")
                                .uri("lb://USER-SERVICE"))

                .route("product-service",
                        r -> r.path("/api/products/**")
                                .uri("lb://PRODUCT-SERVICE"))

                .route("order-service",
                        r -> r.path("/api/orders/**")
                                .uri("lb://ORDER-SERVICE"))

                .route("payment-service",
                        r -> r.path("/api/payments/**")
                                .uri("lb://PAYMENT-SERVICE"))

                .route("inventory-service",
                        r -> r.path("/api/inventory/**")
                                .uri("lb://INVENTORY-SERVICE"))

                .route("notification-service",
                        r -> r.path("/api/notifications/**")
                                .uri("lb://NOTIFICATION-SERVICE"))

                .route("analytics-service",
                        r -> r.path("/api/analytics/**")
                                .uri("lb://ANALYTICS-SERVICE"))

                .build();
    }

}