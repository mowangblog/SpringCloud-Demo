package top.mowang.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringCloud-Demo
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/11/01 14:37
 **/
@Configuration
@SuppressWarnings("all")
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_mowang",
                r -> r.path("/mowang/hystrix-dashboard")
                        .uri("https://mowangblog.top/mowang/hystrix-dashboard")).build();
//        routes.route("path_route_mowang", new Function<PredicateSpec, Route.AsyncBuilder>() {
//            @Override
//            public Route.AsyncBuilder apply(PredicateSpec predicateSpec) {
//                return predicateSpec.path("/mowang/hystrix-dashboard").uri("https://mowangblog.top/mowang/hystrix-dashboard");
//            }
//        }).build();
        return routes.build();
    }
}
