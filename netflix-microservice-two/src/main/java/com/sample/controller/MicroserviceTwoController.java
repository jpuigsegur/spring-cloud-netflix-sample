package com.sample.controller;

import com.sample.model.ErrorResult;
import com.sample.model.ResponseTwo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@Api(value="Test microservice", description="Example microservice API (microservice-two)")
@RequestMapping("/")
public class MicroserviceTwoController {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MicroserviceTwoController.class);

	@Autowired
	DiscoveryClient discoveryClient;

	@ApiOperation(tags = {"sample"},
        value = "Test operation",
        notes = "This is a test operation for microservice-two",
        response = ResponseTwo.class)
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response"),
        @ApiResponse(code = 500, message = "Unexpected error",  response = ErrorResult.class) })
	@RequestMapping(value="/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseTwo testCall() {
		/* Simulate some computing time */
		try {
			Thread.sleep((int) (Math.random() * 250) + 25);
		} catch (InterruptedException e) {
			// do nothing
		}

		/* Fail sometimes ...  */
		if (Math.random() > 0.99) {
			throw new RuntimeException("Random failure");
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
		ResponseTwo result = new ResponseTwo();
		result.setHost(localInstance.getHost());
		result.setPort(localInstance.getPort());
		result.setServiceId(localInstance.getServiceId());
		result.setResult("This is microservice TWO response");
        LOGGER.info("Microservice TWO call");
		return result;
	}
}
