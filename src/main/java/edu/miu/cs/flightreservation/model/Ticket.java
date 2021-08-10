package edu.miu.cs.flightreservation.model;


import edu.miu.cs.flightreservation.service.UtilService;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Ticket")
public class Ticket{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String number;
    private LocalDate date;

    @ManyToOne
    private Flight flight;

    @ManyToOne
    @JoinColumn(name="reservationCode")
    private Reservation reservation;

    public Ticket(){
        this.number = UtilService.generateAlphanumeric(UtilService.DEFAULT_LENGTH);
    }

    public Ticket(String number, LocalDate flightDate) {
        this.number = number;
        this.date = flightDate;
    }




}
