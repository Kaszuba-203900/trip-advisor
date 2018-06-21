package com.tul.ta.controller;
import com.tul.ta.mapper.TicketDtoMapper;
import com.tul.ta.model.Ticket;
import com.tul.ta.model.schedule.Arrival;
import com.tul.ta.model.schedule.Departure;
import com.tul.ta.model.schedule.Flight;
import com.tul.ta.service.TicketService;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TicketController.class)
public class TicketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketService ticketService;

    @MockBean
    private TicketDtoMapper ticketDtoMapper;

    @Test
    public void whenGetTicketsShouldReturnJsonArray() throws Exception {
        long id = 0;
        Random generator = new Random();
        Double price = generator.nextDouble()*1000;
        Ticket ticket = Ticket.builder()
                .ticketId(id)
                .originCityName("LDZ")
                .departureCityName("PAR")
                .dateOfFlight("2018-06-30T06:00")
                .price(price).build();

        List<Ticket> allTickets = Collections.singletonList(ticket);

        given(ticketService.findAll()).willReturn(allTickets);

        mockMvc.perform(get("/api/tickets")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1))).andDo(print());

    }

    @Test
    public void whenSaveTicketThamReturnJson() throws Exception{
        long id = 0;
        Random generator = new Random();
        Double price = generator.nextDouble()*1000;
        Flight flight = Flight.builder()
                .arrival(Arrival.builder().airportCode("KRK")
                        .scheduledTimeLocal("2018-07-15T06:00").build())
                .departure(Departure.builder()
                        .airportCode("MUC")
                        .scheduledTimeLocal("2018-07-15T07:15").build()).build();
        Ticket ticket = Ticket.builder()
                .ticketId(id)
                .originCityName(flight.getArrival().getAirportCode())
                .departureCityName(flight.getDeparture().getAirportCode())
                .dateOfFlight(flight.getArrival().getScheduledTimeLocal())
                .price(price).build();
        when(ticketService.save(ticket)).thenReturn(ticket);
        mockMvc.perform(post("/api/tickets")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(asJsonString(ticket))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());



    }

    public static String asJsonString(Ticket ticket) {
        String jsonContent = "";
        try {
            final ObjectMapper mapper = new ObjectMapper();
            jsonContent = mapper.writeValueAsString(ticket);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonContent;
    }
}
