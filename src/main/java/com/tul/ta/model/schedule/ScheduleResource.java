package com.tul.ta.model.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ScheduleResource {
    @JsonProperty(value = "Schedule")
    List<Schedule> schedule;
}
