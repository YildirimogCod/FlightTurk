package org.yildirimog.flightturk.entity;

import jakarta.persistence.*;
import lombok.*;
import org.yildirimog.flightturk.entity.enums.TicketStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket extends AuditableEntity {

    @Column(unique = true)
    private String ticketNumber;
    private String seatNumber;
    private BigDecimal pricePaid;
    private LocalDateTime bookingDate;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "passenger_id",nullable = false)
    private Passenger passenger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id",nullable = false)
    private Flight flight;

    @PrePersist
    protected void onCreate(){
        if (this.ticketNumber == null){
            this.ticketNumber = UUID.randomUUID().toString().substring(0,6).toUpperCase();
        }
        if (this.bookingDate == null) {
            this.bookingDate = LocalDateTime.now();
        }
    }
}
