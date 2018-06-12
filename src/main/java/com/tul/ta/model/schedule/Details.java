package com.tul.ta.model.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Details {

    @JsonProperty(value = "Stops")
    public Stops stops;

    @JsonProperty(value = "DaysOfOperation")
    public Integer daysOfOperation;

    @JsonProperty(value = "DatePeriod")
    public DatePeriod datePeriod;

}
