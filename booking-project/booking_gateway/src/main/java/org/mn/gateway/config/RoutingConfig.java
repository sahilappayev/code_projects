package org.mn.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {


//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("ms-file", r -> r.path("/file/**")  // http://localhost:8081/file
//                        .filters(f -> f.rewritePath("/file/(?<segment>.*)", "/${segment}"))
//                        .uri("http://localhost:8081"))
//                .route("ms-account", r -> r.path("/account/**")
//                        .filters(f -> f.rewritePath("/account/(?<segment>.*)", "/${segment}"))
//                        .uri("http://localhost:8082"))
//                .route("ms-product", r -> r.path("/product/**")
//                        .filters(f -> f.rewritePath("/product/(?<segment>.*)", "/${segment}"))
//                        .uri("http://localhost:8083"))
//                .build();
//    }


}
