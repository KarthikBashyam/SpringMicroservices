package com.client.serviceapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * Api Gateway application
 * 
 * @author Karthik
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApiGatewayApplication.class, args);
	}

	@Bean
	RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/orders/list").uri("lb://order-service"))
				.route(r -> r.path("/products/list").uri("lb://product-service"))
				.build();
	}
}
