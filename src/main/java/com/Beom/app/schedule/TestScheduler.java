package com.Beom.app.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
//@Component
public class TestScheduler {
	
	//@Scheduled(fixedRate = 1000, initialDelay = 2000)
	//@Scheduled(fixedRateString = "1000", initialDelayString = "2000")
	public void useFixRate() {
		System.out.println("Fix Rate");
	}
	
	//@Scheduled(fixedDelayString = "2000", initialDelayString = "5000")
	public void useFixDelay() {
		System.out.println("Fix Delay");
	}
	
	//@Scheduled(cron = "30 * * * * *")
	public void userCron() {
		System.out.println("Cron");
	}
	
}
