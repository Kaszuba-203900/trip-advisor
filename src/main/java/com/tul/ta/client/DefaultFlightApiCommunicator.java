package com.tul.ta.client;

import com.tul.ta.model.airport.Airport;
import com.tul.ta.model.airport.FlightAirports;
import com.tul.ta.service.AirportService;
import com.tul.ta.util.HttpQueryUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;

public class DefaultFlightApiCommunicator implements FlightApiCommunicator {
    private static final Logger logger = LoggerFactory.getLogger(DefaultFlightApiCommunicator.class);

    private final static String BASE_API_URL = "https://api.lufthansa.com/v1";

    @Autowired
    private HttpQueryUtils httpClient;

    @Autowired
    private AirportService airportService;

    //@Scheduled(fixedDelay = 60000)
    @PostConstruct
    @Override
    public void getAirports() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_API_URL + "/references/airports")
                .queryParam("lang", "EN")
                .queryParam("limit", 100)
                .queryParam("LHoperated", false);

        FlightAirports airports = null;
        try {
            airports = httpClient.executeQuery(builder.toUriString(), FlightAirports.class);
        } catch (HttpClientErrorException e) {
            logger.error(e.toString());
        }

        for (Airport a: airports.getAirportResource().getAirports().getAirport()
                ) {
            this.airportService.save(a);
        }
    }
}
