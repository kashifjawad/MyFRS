package edu.miu.cs.flightreservation.Util.payload.request;

import edu.miu.cs.flightreservation.model.Address;
import edu.miu.cs.flightreservation.model.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@NoArgsConstructor
public class SignupRequest {

    private String username;
    private String password;
    private  String status;
    private String firstName;
    private String lastName;
    private  String email;

    private Set<String> roles;

    private Address address;

}
