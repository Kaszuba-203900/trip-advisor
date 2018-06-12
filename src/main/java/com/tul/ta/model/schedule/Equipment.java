package com.tul.ta.model.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Equipment {

    @JsonProperty(value = "AircraftCode")
    public String aircraftCode;
}
