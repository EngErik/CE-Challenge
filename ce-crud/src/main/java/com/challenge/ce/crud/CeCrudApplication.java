package com.challenge.ce.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ComponentScan("com.challenge.ce.crud")
@EnableJpaRepositories(basePackages = {"com.challenge.ce.crud.user", "com.challenge.crud.atm"})
@SpringBootApplication
public class CeCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeCrudApplication.class, args);
	}
}
