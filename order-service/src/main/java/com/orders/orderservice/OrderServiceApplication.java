package com.orders.orderservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.orders.dao.repository.OrderRepository;
import com.orders.entity.Orders;

@SpringBootApplication(scanBasePackages = "com.orders")
@EnableJpaRepositories(basePackages = "com.orders")
@EntityScan(basePackages = "com.orders.entity")
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner startup() {
		return args -> {
			System.out.println("======== Order Service Started =========");
		};
	}

	@Bean
	CommandLineRunner loadOrderData(OrderRepository orderRepository) {
		return args -> {
			orderRepository.save(new Orders("Bulk Order"));
		};
	}

}
