package com.tul.ta.model.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Departure {

    @JsonProperty(value = "AirportCode")
    public String airportCode;

    @JsonProperty(value = "ScheduledTimeLocal")
    public ScheduledTimeLocal scheduledTimeLocal;

    @JsonProperty(value = "Terminal")
    public Terminal terminal;

}
