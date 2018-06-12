package com.tul.ta.model.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TotalJourney {
    @JsonProperty(value = "Duration")
    public String duration;

}
