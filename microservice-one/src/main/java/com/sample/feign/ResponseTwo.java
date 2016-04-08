package com.sample.feign;

import lombok.Data;

@Data
public class ResponseTwo {
    private String result;
    private String host;
    private int port;
    // not all values of the response need to be unpacked!
    //public String serviceId;
}

