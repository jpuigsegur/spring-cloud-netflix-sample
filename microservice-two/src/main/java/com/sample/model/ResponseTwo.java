package com.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.*;

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

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The current date", required = true)
    public LocalDate date;

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The current timestamp", required = true)
    public LocalDateTime dateTime;

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The current time", required = true)
    public LocalTime time;

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The current timestamp", required = true)
    public OffsetDateTime offsetDateTime;

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The current time", required = true)
    public OffsetTime offsetTime;
}
