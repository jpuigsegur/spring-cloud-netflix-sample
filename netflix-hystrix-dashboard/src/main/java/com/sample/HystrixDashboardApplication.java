package com.sample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
//@EnableTurbine
public class HystrixDashboardApplication {
	public static void main( String[] args )
    {
    	new SpringApplicationBuilder(HystrixDashboardApplication.class).web(true).run(args);
    }
}
