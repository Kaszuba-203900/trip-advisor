package com.tul.ta.model.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Terminal {
    @JsonProperty(value = "Name")
    public Integer name;
}
