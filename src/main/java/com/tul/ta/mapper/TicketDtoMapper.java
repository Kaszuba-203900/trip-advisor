package com.tul.ta.mapper;

import com.tul.ta.dto.TicketDto;
import com.tul.ta.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketDtoMapper implements Mapper<Ticket, TicketDto> {
    @Override
    public Ticket mapToEntity(TicketDto dto){
        return Ticket.builder()
                .ticketId(dto.getTicketId())
                .originCityName(dto.getOriginCityName())
                .departureCityName(dto.getDepartureCityName())
                .dateOfFlight(dto.getDateOfFlight())
                .price(dto.getPrice()).build();
    }

    @Override
    public TicketDto mapToDto(Ticket entity) {
        return TicketDto.builder()
                .ticketId(entity.getTicketId())
                .originCityName(entity.getOriginCityName())
                .departureCityName(entity.getDepartureCityName())
                .dateOfFlight(entity.getDateOfFlight())
                .price(entity.getPrice()).build();
    }
}
