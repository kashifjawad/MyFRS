package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public interface TicketService {

    public Ticket createTicket(Ticket ticket);
    public Optional<Ticket> getTicket(long id);
    public void deleteTicket(Ticket ticket);
    public List<Ticket> getAllTicket();
    public Ticket updateTicket(Long id,Ticket ticket);
}
