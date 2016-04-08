package com.sample.feign;

import org.springframework.stereotype.Component;

@Component
public class MicroserviceTwoFallback implements IMicroserviceTwoClient {
    @Override
    public ResponseTwo testCall() {
        ResponseTwo response = new ResponseTwo();
        response.setResult("FAKED RESULT (FALLBACK)");
        return response;
    }
}
