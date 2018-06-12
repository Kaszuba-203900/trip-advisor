package com.tul.ta.service;

import com.tul.ta.enums.AirportCode;

public interface FlightService {
    String getSchedules(AirportCode origin,
                                 AirportCode destination,
                                 String departureDate,
                                 Boolean directFlight);
}
