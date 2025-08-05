package com.java.hospital_sample.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.hospital_sample.Repositary.UserRepositary;
import com.java.hospital_sample.user.User;


@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserRepositary person;
   
    @GetMapping("/users")
    public List<User> getAllDetails() {
        return person.findAll();
    }

@GetMapping("/users/{id}")
public ResponseEntity<User> getPatientById(@PathVariable int id) {
    return person.findById(id)
        .map(user -> ResponseEntity.ok().body(user))
        .orElse(ResponseEntity.notFound().build());
}


    @PostMapping("/users")
    public User createPatient(@RequestBody User user) {
        return person.save(user);
    }
    
    @PutMapping("/users/{id}")
    public String updatePatient(@PathVariable int id, @RequestBody User user) {
    	if(person.existsById(id)) {
    		person.save(user);
    		return "updated record";
    	}
    	else {
    		return "Person not founded";
    	}
    }
    @DeleteMapping("/users/{id}")
    public String  deletePatient(@PathVariable int id){
    	if(person.existsById(id)) {
    		person.deleteById(id);
    		return "Student deleted";
    	}
    	else {
    		return "student nit found";
    	}
}
}
