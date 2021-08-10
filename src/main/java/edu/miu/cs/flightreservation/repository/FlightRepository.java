package edu.miu.cs.flightreservation.repository;

import edu.miu.cs.flightreservation.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
