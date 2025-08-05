package com.java.hospital_sample.Controller;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.hospital_sample.Repositary.DoctorRepository;
import com.java.hospital_sample.Repositary.UserRepositary;
import com.java.hospital_sample.service.DoctorService;
import com.java.hospital_sample.user.Doctor;
import com.java.hospital_sample.user.User;
 
 
@RestController
@RequestMapping("/admin")
public class AdminController {
 
    @Autowired
    public UserRepositary person;
   
    @GetMapping("/users")
    public List<User> getAllDetails() {
        return person.findAll();
    }
 
@GetMapping("/users/{userid}")
public ResponseEntity<User> getPatientById(@PathVariable int id) {
    return person.findById(id)
        .map(user -> ResponseEntity.ok().body(user))
        .orElse(ResponseEntity.notFound().build());
}
 
 
    @PostMapping("/users")
    public User createPatient(@RequestBody User user) {
        return person.save(user);
    }
    
    @PutMapping("/users/{userid}")
    public String updatePatient(@PathVariable int id, @RequestBody User user) {
    	if(person.existsById(id)) {
    		person.save(user);
    		return "updated record";
    	}
    	else {
    		return "Person not founded";
    	}
    }
    @DeleteMapping("/users/{userid}")
    public String  deletePatient(@PathVariable int id){
    	if(person.existsById(id)) {
    		person.deleteById(id);
    		return "Student deleted";
    	}
    	else {
    		return "student nit found";
    	}
}
    @Autowired
    private DoctorService doctorService;
 
    @GetMapping("/doctor")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
 
    @GetMapping("/doctor/{docid}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
 
    @PostMapping("/doctor")
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }
 
    @PutMapping("/doctor/{docid}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        try {
            Doctor updatedDoctor = doctorService.updateDoctor(id, doctor);
            return ResponseEntity.ok(updatedDoctor);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
 
    @DeleteMapping("/doctor/{docid}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}