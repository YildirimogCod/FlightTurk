package org.yildirimog.flightturk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yildirimog.flightturk.dto.request.PassengerRequestDTO;
import org.yildirimog.flightturk.dto.response.PassengerResponseDTO;
import org.yildirimog.flightturk.entity.Passenger;
import org.yildirimog.flightturk.entity.enums.PassengerStatus;
import org.yildirimog.flightturk.mapper.PassengerMapper;
import org.yildirimog.flightturk.repository.PassengerRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRepository passengerRepository;
    private final PassengerMapper mapper;

    public PassengerResponseDTO createPassenger(PassengerRequestDTO passengerRequestDTO){
      Passenger passenger = mapper.toEntity(passengerRequestDTO);
       if (passengerRepository.existsByEmail(passenger.getEmail())){
           throw new RuntimeException("Email '" + passenger.getEmail() + "' is already registered!");
       }
       if (passengerRepository.existsByPassportNumber(passenger.getPassportNumber())){
           throw new RuntimeException("Passport number is already in use!");
       }
        if (passenger.getStatus() == null) {
            passenger.setStatus(PassengerStatus.ACTIVE);
        }
      Passenger savedPassenger = passengerRepository.save(passenger);
       return mapper.toResponseDto(savedPassenger);
    }

    public List<PassengerResponseDTO> listAll() {
        List<Passenger> passengers = passengerRepository.findAll();
        return mapper.toResponseDtoList(passengers);
    }

    public Passenger getPassengerById(UUID id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found with id: " + id));
    }
}
