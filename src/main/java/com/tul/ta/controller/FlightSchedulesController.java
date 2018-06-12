package com.tul.ta.controller;

import com.tul.ta.enums.AirportCode;
import com.tul.ta.service.FlightService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/flight")
public class FlightSchedulesController {

    private final FlightService flightService;

    public FlightSchedulesController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String getSchedule(
            @RequestParam(value = "origin", required = true) String origin,
            @RequestParam(value = "destination", required = true) String destination,
            @RequestParam(value = "departureDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate
    ) {
        return this.flightService.getSchedules(AirportCode.valueOf(origin), AirportCode.valueOf(destination), departureDate.toString(), true);
        //return this.flightService.getSchedules(AirportCode.FRA, AirportCode.ZRH, "2018-06-11", true);
    }
}
