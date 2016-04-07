package com.sample.feign;

import lombok.Data;

@Data
public class ResponseTwo {
    public String result;
    public String host;
    public int port;
    // not all values of the response need to be unpacked!
    //public String serviceId;
}

