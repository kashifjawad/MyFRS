package edu.miu.cs.flightreservation.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Flight {
    @Id
    @GeneratedValue
    private long id;
    private String number;
    private int capacity;
    private LocalDate departureTime;
    private LocalDateTime arrivalTime;
    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets;
    @ManyToOne
    private Airline airLine;
    @ManyToOne
    private Airport originAirport;
    @ManyToOne
    private Airport destinationAirport;
}