package com.sample.controller;

import com.sample.model.ErrorResult;
import com.sample.model.ResponseTwo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.temporal.ChronoUnit;

@Slf4j
@Controller()
@Api(value="Test microservice", description="Example microservice API (microservice-two)")
@RequestMapping("/microserviceTwo")
class MicroserviceTwoController {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MicroserviceTwoController.class);

    private static final String X_MY_PROCESS_TIME = "X-MyProcessTime";
    private static final String X_MY_TIMESTAMP = "X-MyTimestampt";

	@Autowired
	private DiscoveryClient discoveryClient;

	@ApiOperation(tags = {"sample"},
        value = "Test operation",
        notes = "This is a test operation for microservice-two",
        response = ResponseTwo.class,
		responseHeaders = {
			@ResponseHeader(name = X_MY_PROCESS_TIME, description = "Hotelbeds audit data: process time (in ms)", response = Integer.class),
			@ResponseHeader(name = X_MY_TIMESTAMP, description = "Hotelbeds audit data: timestamp", response = LocalDateTime.class),
		})
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response"),
        @ApiResponse(code = 500, message = "Unexpected error",  response = ErrorResult.class) })
	@RequestMapping(value="/testCallTwo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> testCallTwo() {
        LocalDateTime timestamp = LocalDateTime.now();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(X_MY_TIMESTAMP, timestamp.toString());

		/* Simulate some computing time */
		try {
			Thread.sleep((int) (Math.random() * 250) + 25);
		} catch (InterruptedException e) {
			// do nothing
		}

		/* Fail sometimes ...  */
		if (Math.random() > 0.95) {
            ErrorResult error = new ErrorResult();
            error.setCode(1);
            error.setError("Just decided to fail to make life more interesting");
            httpHeaders.set(X_MY_PROCESS_TIME, Long.toString(ChronoUnit.MILLIS.between(timestamp, LocalDateTime.now())));
            return new ResponseEntity<ErrorResult>(error, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }

		/* Simulate latency spikes % of the time */
		if (Math.random() > 0.95) {
			LOGGER.info("random latency spike !!!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
                // ???
			}
		}

		ServiceInstance localInstance = discoveryClient.getLocalServiceInstance();
		ResponseTwo result = new ResponseTwo();
		result.setHost(localInstance.getHost());
		result.setPort(localInstance.getPort());
		result.setServiceId(localInstance.getServiceId());
		result.setDate(LocalDate.now());
		result.setDateTime(LocalDateTime.now());
		result.setTime(LocalTime.now());
		result.setOffsetDateTime(OffsetDateTime.now());
		result.setOffsetTime(OffsetTime.now());
		result.setResult("This is microservice TWO response");
        LOGGER.info("Microservice TWO call");
        httpHeaders.set(X_MY_PROCESS_TIME, Long.toString(ChronoUnit.MILLIS.between(timestamp, LocalDateTime.now())));
		return new ResponseEntity<ResponseTwo>(result, httpHeaders, HttpStatus.OK);
	}
}
