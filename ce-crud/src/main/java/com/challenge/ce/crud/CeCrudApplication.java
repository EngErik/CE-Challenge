package com.challenge.ce.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ComponentScan("com.challenge.ce.crud")
@EnableJpaRepositories("com.challenge.ce.crud.user")
@SpringBootApplication
public class CeCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeCrudApplication.class, args);
	}
}
