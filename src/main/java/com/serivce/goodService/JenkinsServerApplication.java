package com.serivce.goodService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JenkinsServerApplication {

	public static void main(String[] args) {
		//JenkinsServer에 배포됨.
		SpringApplication.run(JenkinsServerApplication.class, args);
	}

}
