package com.sample.feign;

import org.springframework.stereotype.Component;

@Component
class MicroserviceTwoFallback implements IMicroserviceTwoClient {
    @Override
    public ResponseTwo testCallTwo() {
        ResponseTwo response = new ResponseTwo();
        response.setResult("FAKED RESULT (FALLBACK)");
        return response;
    }
}
