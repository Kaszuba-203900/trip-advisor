package com.tul.ta.model.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MarketingCarrier {

    @JsonProperty(value = "AirlineID")
    public String airlineID;

    @JsonProperty(value = "FlightNumber")
    public Integer flightNumber;


}
