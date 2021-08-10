package edu.miu.cs.flightreservation.controller;

import edu.miu.cs.flightreservation.Util.payload.request.ReservationRequest;
import edu.miu.cs.flightreservation.Util.payload.request.ReservationStatusRequest;
import edu.miu.cs.flightreservation.model.*;
import edu.miu.cs.flightreservation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationServiceImpl reservationService;

    @Autowired
    private FlightServiceImpl flightService;

    @Autowired
    private PersonServiceImp personService;

    @Autowired
    private TicketServiceImp ticketService;

    @GetMapping()
    public ResponseEntity<List<Reservation>> getReservationsByPage(){
        List<Reservation> reservations = reservationService.findAll();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping(params = "page=true")
    public ResponseEntity<Page<Reservation>> getReservationsByPage(Pageable pageable){
        Page<Reservation> reservations = reservationService.findAll(pageable);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PostMapping()
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ResponseEntity<Reservation> createReservation(@RequestBody @Valid ReservationRequest reservation){
        try{
            long[] flights = reservation.getFlights();
            //if(!flightService.exists(flights))
                //return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

            //TODO check if all flights are in the database
            Person person = new Person();
            person.setFirstName(reservation.getFirstName());
            person.setLastName(reservation.getLastName());
            person.setEmail(reservation.getEmail());
            person.setPassportId(reservation.getPassportId());
            person.setPhoneNumber(reservation.getPhoneNumber());
            person.setGender(reservation.getGender());
            //TODO generate the encrypted password
            person.setPassword("password");
            Person _person = personService.save(person);

            Reservation _reservation = new Reservation();
            _reservation.setDepartureDate(reservation.getDepartureDate());
            //TODO get the current authenticated user and pass it
            _reservation.setCreatedBy(null);
            _reservation.setArrivalDate(reservation.getArrivalDate());
            _reservation.setDepartureDate(reservation.getDepartureDate());
            _reservation.setArrivalPlace(reservation.getArrivalPlace());
            _reservation.setDepartureDeparture(reservation.getDeparturePlace());
            reservationService.save(_reservation);
            reservationService.updateStatus(_reservation, reservation.getStatus());
            int i; int j;
            System.out.println(reservation.getTotalPerson());
            for(i=0;  i<reservation.getTotalPerson(); i++){
                for(j=0; j<flights.length; j++) {
                    try{
                        Ticket _ticket = new Ticket();
                        //TODO uncomment
                        //_ticket.setFlight(flightService.findById(flights[j]));
                        _ticket.setFlight(null);
                        _ticket.setReservation(_reservation);
                        //TODO uncomment
                        //_ticket.setDate(_ticket.getFlight().getDepartureTime());
                        ticketService.createTicket(_ticket);
                        System.out.println(_ticket);
                        System.out.println(_ticket.getReservation().getReservationCode());
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }
                }
            }
            return new ResponseEntity(_reservation, HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Long id){
        Reservation _reservation = reservationService.findById(id);
        if(_reservation != null){
            return new ResponseEntity<>(_reservation, HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservationStatus(@PathVariable("id") Long id, @RequestBody ReservationStatusRequest reservation){
        Reservation _reservation = reservationService.findById(id);
        if(_reservation != null){
            reservationService.updateStatus(_reservation, reservation.getStatus());
                return new ResponseEntity<>(reservationService.save(_reservation), HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReservation(@PathVariable("id") Long id){
        Reservation _reservation = reservationService.findById(id);
        if(_reservation != null){
            reservationService.delete(_reservation);
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
