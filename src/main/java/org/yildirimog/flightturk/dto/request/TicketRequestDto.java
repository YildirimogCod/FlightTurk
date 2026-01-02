package org.yildirimog.flightturk.dto.request;

import java.util.UUID;

public record TicketRequestDto(
        UUID passengerId,
        UUID flightId
) {
}
