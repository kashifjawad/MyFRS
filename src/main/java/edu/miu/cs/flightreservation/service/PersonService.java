package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.Util.payload.request.SignupRequest;
import edu.miu.cs.flightreservation.model.Person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface PersonService {

       void createPerson(SignupRequest signupRequest);
       Page<Person> getAllPerson(Pageable pageable);
       Person getOnePersonByUsername(String username);
       void  deletePerson(Long id);
       Person updatePerson(Long id, SignupRequest signupRequest);
       Person getOnePersonById(Long id);

       Person save(Person person);



}
