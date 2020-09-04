package com.spring.atimport.annotation.example;

import org.apache.log4j.Logger;

public class CustomerBo {

	private static final Logger logger = Logger.getLogger(CustomerBo.class);

	public void init() {
		// initialization logic
		logger.info("CustomerBo init method");
	}

	public void cleanup() {
		// destruction logic
		logger.info("CustomerBo destroy method");
	}

	public void printMsg(String msg) {

		logger.info("CustomerBo : " + msg);
	}

}