package org.yildirimog.flightturk.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TicketResponseDTO(
        UUID id,
        String ticketNumber,
        String passengerFullName,
        String flightNumber,
        String seatNumber,
        BigDecimal pricePaid,
        LocalDateTime bookingDate,
        String ticketStatus
) {
}
