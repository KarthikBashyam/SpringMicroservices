package com.products.productservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.products.dao.repository.ProductsRepository;
import com.products.entity.Product;

@SpringBootApplication(scanBasePackages="com.products")
@EnableJpaRepositories(basePackages = "com.products")
@EntityScan(basePackages="com.products.entity")
@EnableAutoConfiguration
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner startup() {
		return (args) -> {
			System.out.println("========== Product Service application started ===========");
		};
	}

	@Bean
	CommandLineRunner loadProductData(ProductsRepository productsRepository) {
		return (args) -> {
			productsRepository.save(new Product("Herschel",1000.0));
			productsRepository.save(new Product("North Face",2000.0));
		};
	}

}
