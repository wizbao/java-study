package com.abot.scheduledtask;

import com.abot.scheduledtask.service.ScheduledService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class ScheduledTaskApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledTaskApplication.class, args);
	}
	@Resource
	private ScheduledService scheduledService;

	@Override
	public void run(String... args) throws Exception {
		scheduledService.startMyTask(1);
	}
}
