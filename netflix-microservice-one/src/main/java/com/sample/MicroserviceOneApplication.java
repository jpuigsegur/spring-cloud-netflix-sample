package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
public class MicroserviceOneApplication {

	// No sampler needed. Only using trace for log correlation
	// @Bean
	// public AlwaysSampler defaultSampler() {
	//	return new AlwaysSampler();
	//}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MicroserviceOneApplication.class, args);
	}
}
