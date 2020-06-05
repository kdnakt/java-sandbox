package com.kdnakt.springboot.threadsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@SpringBootApplication
@EnableScheduling
public class ThreadSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThreadSampleApplication.class, args);
	}

	@Bean
	public ThreadPoolTaskScheduler scheduler() {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(2);
		return  taskScheduler;
	}

}
