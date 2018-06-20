package com.tul.ta.service;

import com.tul.ta.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
}
