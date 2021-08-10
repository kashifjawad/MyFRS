package edu.miu.cs.flightreservation.Util.payload.request;


import edu.miu.cs.flightreservation.model.Address;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class AirportRequest {
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
}
