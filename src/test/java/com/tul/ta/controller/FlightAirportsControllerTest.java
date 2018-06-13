package com.tul.ta.controller;

import com.tul.ta.model.airport.Airport;
import com.tul.ta.service.AirportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(FlightAirportsController.class)
public class FlightAirportsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AirportService airportService;

    @Test
    public void whenGetAirportsShouldReturnJsonArray() throws Exception {
        Airport AAL = new Airport("AAL", "AAL", "DK", "Airport", 2, "Europe/Copenhagen");

        List<Airport> allAirports = Collections.singletonList(AAL);

        given(airportService.getAll()).willReturn(allAirports);

        mockMvc.perform(get("/api/flight/airports")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].AirportCode", is(AAL.getAirportCode())));
    }
}
