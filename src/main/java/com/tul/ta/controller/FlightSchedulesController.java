package com.tul.ta.controller;

import com.tul.ta.enums.AirportCode;
import com.tul.ta.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/flight")
public class FlightSchedulesController {

    @Autowired
    private final FlightService flightService;

    public FlightSchedulesController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String getSchedule(
            @RequestParam(value = "origin") String origin,
            @RequestParam(value = "destination") String destination,
            //@RequestParam(value = "departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate
            @RequestParam(value = "departureDate") String departureDate
    ) {
        return this.flightService.getSchedules(AirportCode.valueOf(origin), AirportCode.valueOf(destination), departureDate.toString(), true);
    }
}
