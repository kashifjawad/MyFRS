package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.Address;
import edu.miu.cs.flightreservation.model.Airport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AirportService {
    public Airport save(Airport airport);
    public List<Airport> findAll();
    public Page<Airport> findAll(Pageable pageable);
    public Airport findById(Long id);
    public void delete(Airport airport);
    public void deleteById(Long id);
}
