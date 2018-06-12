package com.tul.ta.model.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FlightSchedules {
    @JsonProperty(value = "ScheduleResource")
    ScheduleResource scheduleResource;

}
