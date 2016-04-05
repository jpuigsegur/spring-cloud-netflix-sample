package com.sample.controller;

import com.sample.model.ResponseTwo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MicroserviceTwoController {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MicroserviceTwoController.class);

	@Autowired
	DiscoveryClient discoveryClient;
	
	@RequestMapping("/")
	@ResponseBody
	ResponseTwo homeMicroServiceTwo() {
		/* Simulate some computing time */
		try {
			Thread.sleep((int) (Math.random() * 250) + 25);
		} catch (InterruptedException e) {
			// do nothing
		}

		/* Fail rarely ...  */
		if (Math.random() > 0.9999) {
			throw new RuntimeException("random failure loading order over network");
		}

		/* Simulate latency spikes % of the time */
		if (Math.random() > 0.95) {
			LOGGER.info("random latency spike !!!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// do nothing
			}
		}

		ServiceInstance localInstance = discoveryClient.getLocalServiceInstance();
		ResponseTwo responseTwo = new ResponseTwo();
		responseTwo.setHost(localInstance.getHost());
		responseTwo.setPort(localInstance.getPort());
		responseTwo.setServiceId(localInstance.getServiceId());
		responseTwo.setResult("This is microservice TWO response");
        LOGGER.info("Microservice TWO call");
		return responseTwo;
	}
}
