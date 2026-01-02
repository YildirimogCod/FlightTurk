package org.yildirimog.flightturk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yildirimog.flightturk.dto.request.FlightRequestDTO;
import org.yildirimog.flightturk.dto.response.FlightResponseDTO;
import org.yildirimog.flightturk.entity.Flight;
import org.yildirimog.flightturk.entity.enums.FlightStatus;
import org.yildirimog.flightturk.mapper.FlightMapper;
import org.yildirimog.flightturk.repository.FlightRepository;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final FlightMapper mapper;

    public FlightResponseDTO createFlight(FlightRequestDTO flightRequestDTO){
    Flight flight = mapper.toEntity(flightRequestDTO);
    flight.setAvailableSeats(flightRequestDTO.totalCapacity());
    flight.setCurrentPrice(flightRequestDTO.basePrice());
    flight.setFlightStatus(FlightStatus.SCHEDULED);

    if (flightRepository.existsByFlightNumber(flight.getFlightNumber())){
        throw new RuntimeException("Flight number " + flight.getFlightNumber() + " already exists!");
    }
    Flight savedFlight = flightRepository.save(flight);
    return mapper.toResponseDto(savedFlight);

    }
}
