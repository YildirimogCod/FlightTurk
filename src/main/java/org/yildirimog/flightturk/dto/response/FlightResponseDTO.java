package org.yildirimog.flightturk.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record FlightResponseDTO(
        UUID id,
        String flightNumber,
        String departureAirport,
        String arrivalAirport,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime,
        Integer totalCapacity,
        Integer availableSeats,
        BigDecimal currentPrice,
        String flightStatus
) {
}
