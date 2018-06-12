package com.tul.ta.model.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DatePeriod {
    @JsonProperty(value = "Effective")
    public String effective;

    @JsonProperty(value = "Expiration")
    public String expiration;
}
