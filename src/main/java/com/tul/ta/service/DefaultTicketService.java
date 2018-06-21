package com.tul.ta.service;
import com.tul.ta.exception.ResourceNotFoundException;
import com.tul.ta.model.Ticket;
import com.tul.ta.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DefaultTicketService implements TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket save (final Ticket ticket){
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }

    public Ticket findTicketById(Long id){
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", id));
    }

}
