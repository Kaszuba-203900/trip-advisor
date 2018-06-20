package com.tul.ta.service.airports;

import com.tul.ta.model.airport.Airport;

import java.util.List;

public interface AirportService {

    List<Airport> getAll();

    Airport getAirportById(String airportCode);

    void save(Airport temp);
}
