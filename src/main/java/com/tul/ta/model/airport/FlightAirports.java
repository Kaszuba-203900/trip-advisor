package com.tul.ta.model.airport;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FlightAirports {
    @JsonProperty(value = "AirportResource")
    public AirportResource airportResource;
}
