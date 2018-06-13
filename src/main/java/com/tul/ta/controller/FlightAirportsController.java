package com.tul.ta.controller;

import com.tul.ta.exception.ResourceNotFoundException;
import com.tul.ta.model.airport.Airport;
import com.tul.ta.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightAirportsController {

    @Autowired
    AirportRepository airportRepository;

    @RequestMapping(value = "/airports", method = RequestMethod.GET)
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @RequestMapping(value = "/airports/{id}", method = RequestMethod.GET)
    public Airport getAirportyById(@PathVariable(value = "airport_code") String airportCode) {
        return airportRepository.findById(airportCode)
                .orElseThrow(() -> new ResourceNotFoundException("Airport", "id", airportCode));
    }
}
