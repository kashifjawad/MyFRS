package edu.miu.cs.flightreservation.controller;

import edu.miu.cs.flightreservation.model.Flight;
import edu.miu.cs.flightreservation.model.Flight;
import edu.miu.cs.flightreservation.service.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/flights")
public class FlightController {
    @Autowired
    private FlightServiceImpl flightService;

    @GetMapping()
    public ResponseEntity<List<Flight>> getFlightsByPage(){
        List<Flight> flights = flightService.findAll();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping(params = "page=true")
    public ResponseEntity<Page<Flight>> getFlightsByPage(Pageable pageable){
        Page<Flight> Flights = flightService.findAll(pageable);
        return new ResponseEntity<>(Flights, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable("id") Long id){
        Flight flight = flightService.findById(id);
        if(flight != null){
            return new ResponseEntity<>(flight, HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight){
        try{
//            Flight flight = new Flight();
//            flight.setOriginAirport(flight.getOriginAirport());
//            flight.setAirLine(flight.getAirLine());
//            flight.setDestinationAirport(flight.getDestinationAirport());
//            flight.setNumber(flight.getNumber());
            return new ResponseEntity(flightService.create(flight), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable("id") Long id, @RequestBody Flight pFlight){
        Flight flight = flightService.findById(id);
        if(flight != null){
//            flight.setName(Flight.getName());
//            flight.setHistory(Flight.getHistory());
            return new ResponseEntity<>(flightService.update(flight), HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFlight(@PathVariable("id") Long id){
        Flight flight = flightService.findById(id);
        if(flight != null){
            flightService.delete(flight);
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
