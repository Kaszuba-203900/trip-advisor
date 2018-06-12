package com.tul.ta.model.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Schedule {
    @JsonProperty(value = "TotalJourney")
    public TotalJourney totalJourney;

    @JsonProperty(value = "Flight")
    public Flight flight;

}
