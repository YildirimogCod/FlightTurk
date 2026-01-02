package org.yildirimog.flightturk.dto.response;

import java.util.UUID;

public record PassengerResponseDTO(
         UUID id,
         String firstName,
         String lastName,
         String email,
         String status
) {
}
