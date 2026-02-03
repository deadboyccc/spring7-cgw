package dev.dead.spring7cgw;

import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.setPath;
import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.stripPrefix;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;

//@Configuration
abstract public class GatewayConfig {

    //    @Bean
    public RouterFunction<ServerResponse> gatewayRoutes() {
        return route("dummy_routes")
                .route(path("/json/**"), http("https://jsonplaceholder.typicode.com")).filter(setPath("/posts"))
                .route(path("/httpbin/**"), http("https://httpbin.org")).filter(stripPrefix(1))
                .route(path("/dummy/**"), http("https://dummyjson.com")).filter(stripPrefix(1))
                .build();
    }
}
