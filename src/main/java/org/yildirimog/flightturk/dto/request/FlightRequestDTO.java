package org.yildirimog.flightturk.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FlightRequestDTO(
        String flightNumber,
        String departureAirport,
        String arrivalAirport,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime,
        Integer totalCapacity,
        BigDecimal basePrice
) {
}
