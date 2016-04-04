package com.sample.controller;

import com.sample.feign.IMicroserviceTwoClient;
import com.sample.feign.ResponseTwo;
import com.sample.model.ResponseOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MicroserviceOneController {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MicroserviceOneController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private IMicroserviceTwoClient microserviceTwoClient;

    @RequestMapping("/")
    @ResponseBody
    ResponseOne myMicroserviceOne() {
        ServiceInstance localInstance = discoveryClient.getLocalServiceInstance();
        ResponseOne response = new ResponseOne();
        response.setHost(localInstance.getHost());
        response.setPort(localInstance.getPort());
        response.setServiceId(localInstance.getServiceId());
        ResponseTwo responseTwo = microserviceTwoClient.myMicroserviceTwo();
        response.setResult("This is microservice ONE response ([" + responseTwo.getServiceId() + "] result => " + responseTwo.getResult() + ")");
        LOGGER.info("Microservice TWO call");
        return response;
    }
}
