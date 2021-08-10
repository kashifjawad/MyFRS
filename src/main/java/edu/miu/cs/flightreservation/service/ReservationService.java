package edu.miu.cs.flightreservation.service;


import edu.miu.cs.flightreservation.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReservationService {
    Reservation save(Reservation reservation);
    List<Reservation> findAll();
    Page<Reservation> findAll(Pageable pageable);
    Reservation findById(Long id);
    void delete(Reservation reservation);
    void deleteById(Long id);
    boolean updateStatus(Reservation reservation, String status);
}