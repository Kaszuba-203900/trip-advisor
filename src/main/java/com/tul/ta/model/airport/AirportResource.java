package com.tul.ta.model.airport;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AirportResource {
    @JsonProperty(value = "Airports")
    public Airports airports;
}
