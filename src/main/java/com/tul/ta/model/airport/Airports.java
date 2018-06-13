package com.tul.ta.model.airport;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Airports {
    @JsonProperty(value = "Airport")
    public List<Airport> airport;
}
