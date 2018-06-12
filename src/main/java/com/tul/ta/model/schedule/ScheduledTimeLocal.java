package com.tul.ta.model.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ScheduledTimeLocal {

    @JsonProperty(value = "DateTime")
    public String dateTime;

}
