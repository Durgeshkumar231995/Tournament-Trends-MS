package com.tournament.apiGateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.tournament.apiGateway.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class ApiGatewayConfig {
	@Autowired
	AuthenticationFilter filter;
    @Bean
    public RouteLocator MyRoutes(RouteLocatorBuilder builder)
    {
        return builder.routes()
                .route("api/v1", r -> r.path("/api/v1/**")
						.uri("lb://AUTHENTICATIONSERVICE"))
                .route("api/v2", r -> r.path("/api/v2/**")
						.uri("lb://USERPROFILESERVICE"))
                .route("api/v3", r -> r.path("/api/v3/**")
                		.filters(f -> f.filter(filter))
						.uri("lb://RECOMMENDATIONSERVICE"))                
                .route("api/v4", r -> r.path("/api/v4/**")
                		.filters(f -> f.filter(filter))
						.uri("lb://PERFORMANCESERVICE"))                
                .build();
        

		
//      .route(p->p.path("/api/v1/**")
//              .uri("http://localhost:8081/"))
//      .route(p->p.path("/api/v2/**")
//              .uri("http://localhost:8082/"))
//      .route(p->p.path("/api/v3/**")
//              .uri("http://localhost:8083/"))
//      .route(p->p.path("/api/v4/**")
//              .uri("http://localhost:8084/"))
        
    }
}
