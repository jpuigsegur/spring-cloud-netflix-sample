package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class MicroserviceTwoApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MicroserviceTwoApplication.class, args);
	}
}
