package edu.miu.cs.flightreservation.service;


import edu.miu.cs.flightreservation.model.Person;
import edu.miu.cs.flightreservation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImp implements PersonService{

    @Autowired
    private PersonRepository personRepository;


   @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Person getOnePersonByUsername(String username) {
        return personRepository.findPersonByUsername(username);
    }

    @Override
    public void deletePerson(Person person) {

       personRepository.delete(person);

    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Optional<Person> getOnePersonById(Long id) {
        return personRepository.findById(id);
    }
}
