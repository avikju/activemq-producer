package com.avik.activemq.producer.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 985354436241121130L;
	private int productId = 0;
	private String name = null;
	private int quantity = 0;

}