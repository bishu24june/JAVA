package com.spring.atimport.annotation.example;

import org.apache.log4j.Logger;

public class SchedulerBo {

	private static final Logger logger = Logger.getLogger(SchedulerBo.class);

	public void init() {
		// initialization logic
		logger.info("SchedulerConfig init method");
	}

	public void cleanup() {
		// destruction logic
		logger.info("SchedulerConfig destroy method");
	}

	public void printMsg(String msg) {

		logger.info("SchedulerBo : " + msg);
	}

}