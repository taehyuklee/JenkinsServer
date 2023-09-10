package com.serivce.goodService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JenkinsServer {

	public static void main(String[] args) {
		//JenkinsServer에 배포됨.
		SpringApplication.run(JenkinsServer.class, args);
	}

}
