package com.sandip.ecommerce.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoggingFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(org.springframework.web.server.ServerWebExchange exchange,
                             org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();

        log.info("==============================================");
        log.info("Incoming Request");
        log.info("Method : {}", request.getMethod());
        log.info("URI    : {}", request.getURI());
        log.info("Path   : {}", request.getPath());
        log.info("==============================================");

        long startTime = System.currentTimeMillis();

        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {

                    long executionTime =
                            System.currentTimeMillis() - startTime;

                    log.info("==============================================");
                    log.info("Outgoing Response");
                    log.info("Status : {}",
                            exchange.getResponse().getStatusCode());

                    log.info("Execution Time : {} ms",
                            executionTime);

                    log.info("==============================================");

                }));

    }

    @Override
    public int getOrder() {
        return -1;
    }

}