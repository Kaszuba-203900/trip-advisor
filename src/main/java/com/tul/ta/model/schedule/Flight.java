package com.tul.ta.model.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Flight {

    @JsonProperty(value = "Departure")
    public Departure departure;

    @JsonProperty(value = "Arrival")
    public Arrival arrival;

    @JsonProperty(value = "MarketingCarrier")
    public MarketingCarrier marketingCarrier;

    @JsonProperty(value = "Equipment")
    public Equipment equipment;

    @JsonProperty(value = "Details")
    public Details details;


}
