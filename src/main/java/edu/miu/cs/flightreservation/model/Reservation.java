package edu.miu.cs.flightreservation.model;
import edu.miu.cs.flightreservation.service.UtilService;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private long id;
    private String reservationCode;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private String departureDeparture;
    private String arrivalPlace;
    @ManyToOne
    private Person createdBy;
    @ManyToOne
    private Person passenger;
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List <Ticket> tickets= new ArrayList<Ticket>();
    @Enumerated(EnumType.STRING)
    private Status status;

    /*public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
        ticket.setReservation(this);
        ticket.setReservationCode(this.reservationCode);
    }*/

    /*public Reservation(long id, String reservationCode, LocalDate reservationDate, String departureDeparture, String arrivalPlace, Person person, List<Ticket> tickets, Status status) {
        this.id = id;
        this.reservationCode = reservationCode;
        this.reservationDate = reservationDate;
        this.departureDeparture = departureDeparture;
        this.arrivalPlace = arrivalPlace;
        this.createdBy = createdBy;
        this.passenger= passenger;
        this.tickets = tickets;
        this.status = status;
    }*/

    public Reservation() {
        this.reservationCode = UtilService.generateAlphanumeric(UtilService.DEFAULT_LENGTH);
    }

    public void update(Status status){
        this.status=status;
    }

}