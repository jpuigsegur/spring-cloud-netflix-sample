package com.sample.controller;

import com.sample.feign.IMicroserviceTwoClient;
import com.sample.model.ErrorResult;
import com.sample.model.ResponseOne;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@Api(value="Test microservice", description="Example microservice API (microservice-one)")
@RequestMapping("/")
public class MicroserviceOneController {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MicroserviceOneController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private IMicroserviceTwoClient microserviceTwoClient;

    @ApiOperation(tags = {"sample"},
        value = "Test operation",
        notes = "This is a test operation for microservice-one",
        response = ResponseOne.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response"),
        @ApiResponse(code = 500, message = "Unexpected error",  response = ErrorResult.class) })
    @RequestMapping(value="/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseOne testCall() {
        /* Simulate some computing time */
        try {
            Thread.sleep((int) (Math.random() * 50) + 10);
        } catch (InterruptedException e) {
            // do nothing
        }

        /* Fail sometimes ...  */
        if (Math.random() > 0.99) {
            throw new RuntimeException("Random failure");
        }

        ServiceInstance localInstance = discoveryClient.getLocalServiceInstance();
        ResponseOne response = new ResponseOne();
        response.setHost(localInstance.getHost());
        response.setPort(localInstance.getPort());
        response.setServiceId(localInstance.getServiceId());
        // Call microserviceTwo.testCall()
        response.setResponseTwo(microserviceTwoClient.testCall());
        response.setResult("This is microservice ONE response");
        LOGGER.info("Microservice ONE call");
        return response;
    }
}
