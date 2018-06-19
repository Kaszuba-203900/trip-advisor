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
    public Integer ticketId;
    @Column(name = "from_city")
    public String fromCityName;
    @Column(name = "to_city")
    public String toCityName;
    @Column(name = "date_of_flight")
    public Date dateOfFlight;
    @Column(name = "price")
    public Double price;

    @Builder
    public Ticket(Integer ticketId, String fromCityName, String toCityName, Date dateOfFlight, Double price) {
        this.ticketId = ticketId;
        this.fromCityName = fromCityName;
        this.toCityName = toCityName;
        this.dateOfFlight = dateOfFlight;
        this.price = price;
    }

    @Tolerate
    public Ticket(){

    }
}
