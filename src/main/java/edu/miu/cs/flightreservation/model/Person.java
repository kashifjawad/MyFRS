package edu.miu.cs.flightreservation.model;


import lombok.*;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString(exclude = "roles")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private  String status;
    private String firstName;
    private String lastName;
    private  String email;
    private String passportId;
    private String phoneNumber;
    private String gender;

    public Person(){
        this.status = "ACTIVE";
    }

    @ManyToMany(mappedBy = "people")
    private Set<Role> roles= new HashSet<>();
    @Embedded
    private Address address;

    public Person(String username, String password,
                  String status, String firstName,
                  String lastName, String email,Address address) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address=address;
    }

    public boolean addRoles(Role role){
        boolean status=false;
        if (roles.add(role)){
            role.addOnePeson(this);
            status=true;
        }
        return status;
    }

    public boolean addOneRole(Role role){
     return this.roles.add(role);
    }
}
