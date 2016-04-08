package com.sample.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "microservice-two", fallback = MicroserviceTwoFallback.class)
public interface IMicroserviceTwoClient {
	 @RequestMapping(method = RequestMethod.GET, value = "/microservice-two/")
	 ResponseTwo testCall();
}
