package com.tul.ta.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TicketDto {
    @JsonProperty("TicketId")
    public Integer ticketId;
    @JsonProperty("OriginCityName")
    public String originCityName;
    @JsonProperty("DepartureCityName")
    public String departureCityName;
    @JsonProperty("DateOfFlight")
    public Date dateOfFlight;
    @JsonProperty("Price")
    public Double price;

    @Builder

    public TicketDto(Integer ticketId, String originCityName, String departureCityName, Date dateOfFlight, Double price) {
        this.ticketId = ticketId;
        this.originCityName = originCityName;
        this.departureCityName = departureCityName;
        this.dateOfFlight = dateOfFlight;
        this.price = price;
    }
}
