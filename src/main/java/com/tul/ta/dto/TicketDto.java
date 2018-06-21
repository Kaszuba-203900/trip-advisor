package com.tul.ta.dto;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class TicketDto {
    @JsonProperty("TicketId")
    public Long ticketId;
    @JsonProperty("OriginCityName")
    public String originCityName;
    @JsonProperty("DepartureCityName")
    public String departureCityName;
    @JsonProperty("DateOfFlight")
    public String dateOfFlight;
    @JsonProperty("Price")
    public Double price;

    @JsonCreator
    public TicketDto(@JsonProperty("TicketId") Long ticketId, @JsonProperty("OriginCityName") String originCityName, @JsonProperty("DepartureCityName") String departureCityName,
                     @JsonProperty("DateOfFlight") String dateOfFlight, @JsonProperty("Price") Double price) {
        this.ticketId = ticketId;
        this.originCityName = originCityName;
        this.departureCityName = departureCityName;
        this.dateOfFlight = dateOfFlight;
        this.price = price;
    }
}
