package com.sample.model;

import com.sample.feign.ResponseTwo;

public class ResponseOne {
    public String result;
    public String host;
    public int port;
    public String serviceId;

    public ResponseTwo responseTwo;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public ResponseTwo getResponseTwo() {
        return responseTwo;
    }

    public void setResponseTwo(ResponseTwo responseTwo) {
        this.responseTwo = responseTwo;
    }
}
