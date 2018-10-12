package com.application.common.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfiguration {

	@Bean
	SampleCLR helloConfig() {
		return new SampleCLR();
	}

	class SampleCLR implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			System.out.println("========= INSIDE CUSTOM SPRING BOOT STARTER ============");

		}

	}

}
