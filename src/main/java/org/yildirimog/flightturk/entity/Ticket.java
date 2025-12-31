package org.yildirimog.flightturk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket extends AuditableEntity {

}
