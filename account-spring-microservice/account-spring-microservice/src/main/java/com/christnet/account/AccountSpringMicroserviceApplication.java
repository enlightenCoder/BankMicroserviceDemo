package com.christnet.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@EnableJpaRepositories("com.christnet.account.repository")
//@ComponentScans({ @ComponentScan("com.chrisnet.account.controller")})
//@EntityScan("com.chrisnet.account.model")
@EnableFeignClients
@SpringBootApplication
public class AccountSpringMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountSpringMicroserviceApplication.class, args);
	}

}
