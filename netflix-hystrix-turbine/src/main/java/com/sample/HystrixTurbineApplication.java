package com.sample;

import com.netflix.turbine.discovery.InstanceDiscovery;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class HystrixTurbineApplication {

	public static void main( String[] args )
    {
        new SpringApplicationBuilder(HystrixTurbineApplication.class).web(true).run(args);
    }
}
