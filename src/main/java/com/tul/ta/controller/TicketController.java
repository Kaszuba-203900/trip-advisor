package com.tul.ta.controller;
import com.tul.ta.dto.TicketDto;
import com.tul.ta.mapper.TicketDtoMapper;
import com.tul.ta.model.Ticket;
import com.tul.ta.service.DefaultTicketService;
import com.tul.ta.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TicketController {
    private final Logger logger = LoggerFactory.getLogger(TicketController.class);

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketDtoMapper ticketDtoMapper;

    @RequestMapping(value = "/tickets", method = RequestMethod.POST)
    public ResponseEntity addTicket(@RequestBody TicketDto ticketDto){
        TicketDto saved = ticketDtoMapper.mapToDto(ticketService.save(ticketDtoMapper.mapToEntity(ticketDto)));
        return ResponseEntity.ok(saved);
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public ResponseEntity getTickets(){
        List<Ticket> tickets = ticketService.findAll();
        List<TicketDto> ticketDtos = tickets.stream().map(ticket -> ticketDtoMapper.mapToDto(ticket)).collect(Collectors.toList());
        return ResponseEntity.ok(ticketDtos);
    }

}
