package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.Address;
import edu.miu.cs.flightreservation.model.Airline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AirlineService {
    public Airline save(Airline airline);
    public List<Airline> findAll();
    public Page<Airline> findAll(Pageable pageable);
    public Airline findById(Long id);
    public void delete(Airline airline);
    public void deleteById(Long id);
}
