package com.avik.activemq.producer.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avik.activemq.producer.model.Product;
import com.avik.activemq.producer.service.ProducerService;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProducerResource.class);
	
	@Autowired
	private ProducerService messageProducer;
	
	@PostMapping
	public String publish(@RequestBody Product product) {
		LOGGER.info("Publishing:"+product);
		messageProducer.sendMessage(product);
		LOGGER.info("Succesfully published:"+product);
		return "Published Successfully";
	}
	
}
