package com.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="Error information")
public class ErrorResult {

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "Error code", required = true)
    private Integer code;

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "Error description", required = true)
    private String error;
}
