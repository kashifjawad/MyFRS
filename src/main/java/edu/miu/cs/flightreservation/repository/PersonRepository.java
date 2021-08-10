package edu.miu.cs.flightreservation.repository;

import edu.miu.cs.flightreservation.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findPersonByUsername(String username);
    Person findPersonById(Long id);

}