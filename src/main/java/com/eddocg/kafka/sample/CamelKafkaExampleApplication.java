package com.eddocg.kafka.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:spring/camel-context.xml"})
public class CamelKafkaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelKafkaExampleApplication.class, args);
	}

}
