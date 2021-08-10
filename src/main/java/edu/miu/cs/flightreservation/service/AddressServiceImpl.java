package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
//    @Autowired
//    private AddressRepository addressRepository;
//
//    @Override
//    public Address save(Address address) {
//        return addressRepository.save(address);
//    }
//
//    @Override
//    public List<Address> findAll() {
//        return addressRepository.findAll();
//    }
//
//    @Override
//    public Page<Address> findAll(Pageable pageable) {
//        return addressRepository.findAll(pageable);
//    }
//
//    @Override
//    public Address findById(Long id) {
//        return addressRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void delete(Address address) {
//        addressRepository.delete(address);
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        addressRepository.deleteById(id);
//    }
}
