package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.*;
import edu.miu.cs.flightreservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Page<Reservation> findAll(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public boolean updateStatus(Reservation reservation, String status) {
        if(status.isBlank())
            return false;
        switch (status){
            case "reserved" :
                reservation.setStatus(Status.RESERVED);
                break;
            case "confirmed" :
                reservation.setStatus(Status.CONFIRMED);
                break;
            case "cancelled" :
                reservation.setStatus(Status.CANCELLED);
                break;
            default:
                return false;
        }
        reservationRepository.save(reservation);
        return true;
    }


}