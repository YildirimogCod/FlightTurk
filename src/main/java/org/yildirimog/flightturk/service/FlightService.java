package org.yildirimog.flightturk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yildirimog.flightturk.entity.Flight;
import org.yildirimog.flightturk.repository.FlightRepository;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;

    public Flight createFlight(Flight flight){
    if (flightRepository.findByFlightNumber(flight.getFlightNumber())){
        throw new RuntimeException("Flight number " + flight.getFlightNumber() + " already exists!");
    }
    flight.setAvailableSeats(flight.getTotalCapacity());
    return flightRepository.save(flight);


    }
}
