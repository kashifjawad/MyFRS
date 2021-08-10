package edu.miu.cs.flightreservation.repository;

import edu.miu.cs.flightreservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}