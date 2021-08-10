package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.Airline;
import edu.miu.cs.flightreservation.model.Flight;
import edu.miu.cs.flightreservation.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepository repository;

    @Override
    public List<Flight> findAll() {
        List<Flight> flights = repository.findAll();
        Collections.sort(flights, Comparator.comparing(Flight::getNumber));
        return flights;
    }

    @Override
    public Page<Flight> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @Override
    public Flight findById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public Flight update(Flight flight) {
        return repository.save(flight);
    }

    @Override
    public Flight create(Flight flight) {
        return repository.save(flight);
    }

    @Override

    public boolean exists(long[] flights) {
        boolean result = true;
        for (int i = 0; i < flights.length; i++) {
            Flight flight = repository.findById(flights[i]).orElse(null);
            if (flight == null)
                result = false;
        }
        return result;


    }
    public void delete (Flight flight){
        repository.delete(flight);

    }
}