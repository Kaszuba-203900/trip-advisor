package com.tul.ta.model.airport;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Coordinate {

    @JsonProperty(value = "Latitude")
    public Double latitude;

    @JsonProperty(value = "Longitude")
    public Double longitude;
}
