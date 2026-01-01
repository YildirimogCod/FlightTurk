package org.yildirimog.flightturk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yildirimog.flightturk.entity.Flight;
import org.yildirimog.flightturk.entity.Passenger;
import org.yildirimog.flightturk.entity.Ticket;
import org.yildirimog.flightturk.entity.enums.TicketStatus;
import org.yildirimog.flightturk.repository.FlightRepository;
import org.yildirimog.flightturk.repository.PassengerRepository;
import org.yildirimog.flightturk.repository.TicketRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final PassengerRepository passengerRepository;
    private final FlightRepository flightRepository;
    @Transactional
    public Ticket buyTicket(UUID passengerId, UUID flightId, String seatNumber){
        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new RuntimeException("Passenger not found!"));
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found!"));
        if (flight.getAvailableSeats() <= 0){
            throw new RuntimeException("No available seats for this flight!");
        }
        flight.setAvailableSeats(flight.getAvailableSeats()-1);
        flightRepository.save(flight);
        Ticket ticket = Ticket.builder()
                .passenger(passenger)
                .flight(flight)
                .seatNumber(seatNumber)
                .pricePaid(flight.getCurrentPrice())
                .ticketStatus(TicketStatus.BOOKED)
                .build();

        return ticketRepository.save(ticket);

    }
}
