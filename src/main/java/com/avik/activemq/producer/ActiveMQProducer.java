package com.avik.activemq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ActiveMQProducer {

	public static void main(String[] args) {
		SpringApplication.run(ActiveMQProducer.class, args);
	}

}
