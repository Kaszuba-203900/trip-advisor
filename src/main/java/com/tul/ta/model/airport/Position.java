package com.tul.ta.model.airport;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Position {

    @JsonProperty(value = "Coordinate")
    public Coordinate coordinate;
}
