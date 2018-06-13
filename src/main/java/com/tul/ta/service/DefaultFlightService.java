package com.tul.ta.service;

import com.tul.ta.enums.AirportCode;
import com.tul.ta.model.schedule.FlightSchedules;
import com.tul.ta.util.HttpQueryUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Service
public class DefaultFlightService implements FlightService{
    private static final Logger logger = LoggerFactory.getLogger(DefaultFlightService.class);

    private final static String BASE_API_URL = "https://api.lufthansa.com/v1";

    @Autowired
    private HttpQueryUtils httpClient;

    @Cacheable
    @Override
    public String getSchedules(AirportCode origin, AirportCode destination, String departureDate, Boolean directFlight) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_API_URL + "/operations/schedules/" + origin + "/" + destination + "/" + departureDate)
                .queryParam("directFlights", directFlight);

        FlightSchedules schedule = null;
        try {
            schedule = httpClient.executeQuery(builder.toUriString(), FlightSchedules.class);
        } catch (HttpClientErrorException e){
            logger.error(e.toString());
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        try {
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schedule);
        } catch (IOException e) {
            logger.error(e.toString());
        }
        return jsonInString;
    }
}
