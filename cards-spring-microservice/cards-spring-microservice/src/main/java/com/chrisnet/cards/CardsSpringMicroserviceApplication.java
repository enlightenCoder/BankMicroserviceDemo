package com.chrisnet.cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

// the refresh scope annotation will create an endpoint or a url in the actuator, and the url will be /refresh so that whenever there
// is/are changes made in the properties files we can just called this endpoint. [expose endpoint by doing some condig in properties file]
@RefreshScope
@SpringBootApplication
public class CardsSpringMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsSpringMicroserviceApplication.class, args);
	}

}
