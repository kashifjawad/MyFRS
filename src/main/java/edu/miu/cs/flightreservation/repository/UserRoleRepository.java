package edu.miu.cs.flightreservation.repository;


import edu.miu.cs.flightreservation.model.ERole;
import edu.miu.cs.flightreservation.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository  extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole eRole);
}
