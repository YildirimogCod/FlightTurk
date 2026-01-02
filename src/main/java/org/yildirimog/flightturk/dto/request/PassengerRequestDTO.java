package org.yildirimog.flightturk.dto.request;

public record PassengerRequestDTO(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String passportNumber
) {
}
