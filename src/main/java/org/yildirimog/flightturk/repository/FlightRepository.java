package org.yildirimog.flightturk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yildirimog.flightturk.entity.Flight;

import java.util.UUID;

@Repository
public interface FlightRepository extends JpaRepository<Flight, UUID> {
    boolean existsByFlightNumber(String flightNumber);
}
