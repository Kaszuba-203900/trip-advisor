package com.tul.ta.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@EqualsAndHashCode()
@Data
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column(name = "ticket_id")
    public Long ticketId;
    @Column(name = "origin_city")
    public String originCityName;
    @Column(name = "departure_city")
    public String departureCityName;
    @Column(name = "date_of_flight")
    public String dateOfFlight;
    @Column(name = "price")
    public Double price;

    @Builder
    public Ticket(Long ticketId, String originCityName, String departureCityName, String dateOfFlight, Double price) {
        this.ticketId = ticketId;
        this.originCityName = originCityName;
        this.departureCityName = departureCityName;
        this.dateOfFlight = dateOfFlight;
        this.price = price;
    }



    @Tolerate
    public Ticket(){
    }
}
