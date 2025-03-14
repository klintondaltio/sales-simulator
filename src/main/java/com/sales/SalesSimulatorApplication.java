package com.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sales")
public class SalesSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesSimulatorApplication.class, args);
	}

}
