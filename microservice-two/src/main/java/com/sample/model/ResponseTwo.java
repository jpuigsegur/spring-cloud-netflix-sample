package com.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description="Structure returned by microservice-two demo method")
public class ResponseTwo {

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The result itself. In this case just a string :-)", required = true)
    public String result;

    @JsonProperty(required = false)
    @ApiModelProperty(notes = "Name of the server resolving the request", required = false)
    public String host;

    @JsonProperty(required = false)
    @ApiModelProperty(notes = "Port of the server resolving the request", required = false)
    public int port;

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The microservice Id", required = true)
    public String serviceId;
}
