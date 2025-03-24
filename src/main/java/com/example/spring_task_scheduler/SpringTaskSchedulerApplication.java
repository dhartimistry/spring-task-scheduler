package com.example.spring_task_scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringTaskSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTaskSchedulerApplication.class, args);
	}

}
