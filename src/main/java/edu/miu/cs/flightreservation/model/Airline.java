package edu.miu.cs.flightreservation.model;


import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;


import javax.persistence.*;


@Data
@Entity
@SecondaryTable(name = "airlinehistories")
public class Airline {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @Column(table="airlinehistories")

    private String history;
}
