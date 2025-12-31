package org.yildirimog.flightturk.entity;

import jakarta.persistence.*;
import lombok.*;
import org.yildirimog.flightturk.entity.enums.FlightStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight extends AuditableEntity{
    @Column(unique = true)
    private String flightNumber;
    @Column(nullable = false)
    private String departureAirport;
    @Column(nullable = false)
    private String arrivalAirport;
    @Column(nullable = false)
    private LocalDateTime departureTime;
    @Column(nullable = false)
    private LocalDateTime arrivalTime;
    private Integer totalCapacity;
    private Integer availableSeats;
    private BigDecimal basePrice;
    private BigDecimal currentPrice;
    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;

}
