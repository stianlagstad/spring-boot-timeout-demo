package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
public class TimeoutDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeoutDemoApplication.class, args);
    }
}

