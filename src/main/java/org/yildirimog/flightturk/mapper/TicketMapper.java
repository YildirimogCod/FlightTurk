package org.yildirimog.flightturk.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.yildirimog.flightturk.dto.response.TicketResponseDTO;
import org.yildirimog.flightturk.entity.Ticket;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    @Mapping(target = "passengerFullName", expression = "java(ticket.getPassenger().getFirstName() + \" \" + ticket.getPassenger().getLastName())")
    @Mapping(target = "flightNumber", source = "flight.flightNumber")
    TicketResponseDTO toResponseDTO(Ticket ticket);
}
