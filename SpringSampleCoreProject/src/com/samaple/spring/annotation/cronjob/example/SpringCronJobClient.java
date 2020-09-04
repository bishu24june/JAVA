package com.samaple.spring.annotation.cronjob.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

class InventoryPullerJob {

	// @Scheduled(fixedRate=60*60*1000, initialDelay=10*60*1000)
	@Scheduled(cron = "*/2 * * * * MON-FRI")
	public void updateEmployeeInventory() {
		System.out.println("Started fixed delay job");
		/**
		 * add your scheduled job logic here
		 */
	}
}

@EnableScheduling
public class SpringCronJobClient {

	public static void main(String[] args) {
		new InventoryPullerJob().updateEmployeeInventory();

	}

}
