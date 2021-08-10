package edu.miu.cs.flightreservation.Util.payload.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationRequest {
    private String firstName;
    private String lastName;
    private String departurePlace;
    private String arrivalPlace;
    private String email;
    private String gender;
    private String phoneNumber;
    private String passportId;
    private long[] flights;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private int totalPerson;
    private String status;
}
