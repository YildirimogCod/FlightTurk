package org.yildirimog.flightturk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yildirimog.flightturk.entity.Passenger;

import java.util.UUID;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger, UUID> {
    boolean existsByEmail(String email);

    boolean existsByPassportNumber(String passportNumber);
}
