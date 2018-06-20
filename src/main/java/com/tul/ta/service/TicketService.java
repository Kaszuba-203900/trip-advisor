package com.tul.ta.service;
import com.tul.ta.model.Ticket;
import java.util.List;


public interface TicketService {
    List<Ticket> findAll();
    Ticket save(final Ticket ticket);
    Ticket findTicketById(Long id);


}
