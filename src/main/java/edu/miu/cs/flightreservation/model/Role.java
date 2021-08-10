package edu.miu.cs.flightreservation.model;

import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@ToString(exclude = "people")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private ERole name;
    @ManyToMany
    @JoinTable(name="person_role",
            joinColumns = @JoinColumn(name="role_id"),
            inverseJoinColumns = @JoinColumn(name="person_id"))
    private List<Person> people=new ArrayList<>();


    public Role (ERole name){
        this.name=name;
    }


    public boolean addPerson(Person person){
        boolean status=false;
        if (people.add(person)){
            person.addOneRole(this);
            status=true;
        }
        return status;
    }

    public boolean addOnePeson(Person person){
        return  people.add(person);
    }
}
