package com.javafullstackfeb.airlinereservationsystemspring.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("flightResponse")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class FlightResponse {
    private boolean error;
    private String message;
    private List<Object> data;
}
