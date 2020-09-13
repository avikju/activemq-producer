package com.avik.activemq.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.avik.activemq.producer.model.Product;


@Component
public class ProducerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);
	
	@Value("${activemq.queue.name}")
	private String queueName;
	
	
	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendMessage(Product product) {
		LOGGER.info("Sending : " + product);
		jmsTemplate.convertAndSend(queueName, product);

	}

}