package pl.mw.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/users/**")
                        .uri("lb://users-service"))
                .route(r -> r.path("/service/users/**")
                        .uri("lb://users-service"))

                .route(r -> r.path("/payments/**")
                        .uri("lb://payments-service"))
                .route(r -> r.path("/service/payments/**")
                        .uri("lb://payments-service"))

                .route(r -> r.path("/restapi/**")
                        .uri("lb://restapi-service"))
                .route(r -> r.path("/service/restapi/**")
                        .uri("lb://restapi-service"))

                .route(r -> r.path("/swagger-ui/**")
                        .uri("lb://api-service"))
                .route(r -> r.path("/v3/**")
                        .uri("lb://api-service"))

                .route(r -> r.path("/actuator/**")
                        .uri("localhost:8080"))
                .route(r -> r.path("/eureka-client/**")
                        .uri("lb://eureka-client"))
                .build();
    }
}
