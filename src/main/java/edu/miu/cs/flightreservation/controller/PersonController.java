package edu.miu.cs.flightreservation.controller;

import edu.miu.cs.flightreservation.Util.payload.request.SignupRequest;
import edu.miu.cs.flightreservation.model.Person;
import edu.miu.cs.flightreservation.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/persons")
public class PersonController {

    @Autowired
    private PersonServiceImp personServiceImp;

    @GetMapping ("/{id}")
    public ResponseEntity<?> getOnePerson(@PathVariable Long id){

        ResponseEntity<?> responseEntity=null;
        try {

            Person getUser = personServiceImp.getOnePersonById(id);
            if (getUser != null) {

                responseEntity=new ResponseEntity<>(getUser, HttpStatus.OK);
            }
        } catch (Exception e) {
            responseEntity =new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
        return responseEntity;
    }


    @PostMapping("signup")
    public ResponseEntity<?> createPerson(@RequestBody SignupRequest signupRequest){

        ResponseEntity<?> responseEntity=null;
        try {

              personServiceImp.createPerson(signupRequest);


                responseEntity=new ResponseEntity<>("User successfully created"+signupRequest, HttpStatus.OK);

        } catch (Exception e) {
            responseEntity =new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@RequestBody Long id){

        ResponseEntity<?> responseEntity=null;
        try {

            personServiceImp.deletePerson(id);
            responseEntity =new ResponseEntity<>("user successfully", HttpStatus.OK);

        } catch (Exception e) {
            responseEntity =new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
        return responseEntity;
    }

    @GetMapping(params = "paged=true")
    public ResponseEntity<?> findAllPersons(Pageable page) {

        ResponseEntity<?> responseEntity=null;
        try {

           Page<Person> persons= personServiceImp.getAllPerson(page);
            responseEntity =new ResponseEntity<>(persons, HttpStatus.OK);

        } catch (Exception e) {
            responseEntity =new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
        return responseEntity;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Long id,@RequestBody SignupRequest person){

        ResponseEntity<?> responseEntity=null;
        try {

            Person getUser = personServiceImp.updatePerson(id,person);
            if (getUser != null) {

                responseEntity=new ResponseEntity<>(getUser, HttpStatus.OK);
            }
        } catch (Exception e) {
            responseEntity =new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
        return responseEntity;
    }
}
