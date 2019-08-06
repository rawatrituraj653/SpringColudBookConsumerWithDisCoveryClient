package com.st.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringColudBookConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringColudBookConsumerApplication.class, args);
	}

}
