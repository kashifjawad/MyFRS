package edu.miu.cs.flightreservation.repository;

import edu.miu.cs.flightreservation.model.Person;
import edu.miu.cs.flightreservation.model.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    Ticket findTicketById(Long id);
}
