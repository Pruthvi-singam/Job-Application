package com.pruthvi.jobMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class JobMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobMsApplication.class, args);
	}

}
