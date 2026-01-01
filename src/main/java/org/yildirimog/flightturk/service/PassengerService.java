package org.yildirimog.flightturk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yildirimog.flightturk.entity.Passenger;
import org.yildirimog.flightturk.entity.enums.PassengerStatus;
import org.yildirimog.flightturk.repository.PassengerRepository;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRepository passengerRepository;

    public Passenger createPassenger(Passenger passenger){
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
       return savedPassenger;
    }
}
