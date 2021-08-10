package edu.miu.cs.flightreservation.service;



import edu.miu.cs.flightreservation.Util.payload.request.SignupRequest;
import edu.miu.cs.flightreservation.model.ERole;
import edu.miu.cs.flightreservation.model.Role;
import edu.miu.cs.flightreservation.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserRoleService {
      @Autowired
      public UserRoleRepository roleRepository;

      private  static final String ADMIN="ADMIN";
    private  static final String AGENT="AGENT";
    private  static final String  PASSANGER="PASSANGER";


    public Role saveRole(Role role) {
return  roleRepository.save(role);
    }

    public Optional<Role> findRoleByName(ERole name)
    {
        return  roleRepository.findByName(name);
    }


    public ERole convertEnumTOString(SignupRequest signupRequest) {
        Set<String> strRoles = signupRequest.getRoles();
        if (strRoles.contains( ADMIN)) {
            return ERole.ADMIN;
        }
        if (strRoles.contains(AGENT)) {
            return ERole.AGENT;
        }
        return ERole.PASSANGER;


    }

    public Set<Role> convertToEnumRole(SignupRequest signupRequest) {
        Set<String> strRoles = signupRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.PASSANGER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case ADMIN:
                        Role adminRole = roleRepository.findByName(ERole.ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case AGENT:
                        Role agent = roleRepository.findByName(ERole.AGENT)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(agent);
                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERole.PASSANGER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

   return roles;
    }
}
