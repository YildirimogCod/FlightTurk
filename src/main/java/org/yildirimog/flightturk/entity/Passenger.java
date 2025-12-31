package org.yildirimog.flightturk.entity;

import jakarta.persistence.*;
import lombok.*;
import org.yildirimog.flightturk.entity.enums.PassengerStatus;
import java.math.BigDecimal;

@Entity
@Table(name = "passengers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Passenger extends AuditableEntity {
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false,unique = true)
    private String passportNumber;
    @Builder.Default
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal loyaltyPoints = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PassengerStatus status;
}
