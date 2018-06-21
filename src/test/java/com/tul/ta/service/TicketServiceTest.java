package com.tul.ta.service;
import com.tul.ta.exception.ResourceNotFoundException;
import com.tul.ta.model.Ticket;
import com.tul.ta.model.schedule.Arrival;
import com.tul.ta.model.schedule.Departure;
import com.tul.ta.model.schedule.Flight;
import com.tul.ta.repository.TicketRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringRunner.class)
public class TicketServiceTest {

    @TestConfiguration
    static class TicketServiceTestContextConfiguration {
        @Bean
        public TicketService ticketService() {
            return new DefaultTicketService();
        }
    }

    @MockBean
    private TicketRepository ticketRepository;

    @Autowired
    private TicketService ticketService;

    @Test
    public void serviceClassesPathShoudBeCorrect(){
        assertEquals("class com.tul.ta.service.DefaultTicketService", ticketService.getClass().toString());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void whenValidTicketIdThenTicketShouldBeFound() {
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

        when(ticketRepository.findById(ticket.getTicketId())
                .orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", 0)))
                .thenReturn(ticket);

        long ticketId = 0;
        Ticket found = ticketService.findTicketById(ticketId);

        assertEquals(found.getOriginCityName(), ticket.getOriginCityName());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void whenFindTicketByIdShouldThrowNotFoundException() throws ResourceNotFoundException {
        long id = 1;
        when(ticketRepository.findById(id)).thenThrow(new ResourceNotFoundException("Airport", "id", id));

        ticketService.findTicketById(id);

        verify(ticketRepository, times(1)).findById(id);
        verifyNoMoreInteractions(ticketRepository);
    }

    @Test
    public void findAllShouldReturnListOfAirportEntries() {
        List<Ticket> tickets = new ArrayList<>();
        when(ticketRepository.findAll()).thenReturn(tickets);
        List<Ticket> actual = ticketService.findAll();
        assertEquals(actual, tickets);
    }


}
