package edu.miu.cs.flightreservation.repository;

import edu.miu.cs.flightreservation.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AirlineRepository extends JpaRepository<Airline, Long> {

}