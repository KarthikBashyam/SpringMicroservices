package com.client.serviceapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 * Api Gateway application
 * 
 * @author Karthik
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApiGatewayApplication.class, args);
	}

	@Bean
	RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r
						.path("/orders")
						.filters(f -> f.rewritePath("/orders", "/orders/list")
									   .hystrix(cmd -> cmd.setName("ordercmd").setFallbackUri("forward:/fallback")))
						.uri("lb://order-service"))
				.route(r -> r
						.path("/products")
						.filters(f -> f.rewritePath("/products", "/products/list"))
						.uri("lb://product-service"))
				.build();
	}
	
	@RequestMapping("/mapping")
	private Mono<String> fallback() {
		return Mono.just("fallback");
	}
}
