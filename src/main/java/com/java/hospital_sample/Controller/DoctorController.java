package com.java.hospital_sample.Controller;

import com.java.hospital_sample.user.*;
import com.java.hospital_sample.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{docid}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long docid) {
        return doctorService.getDoctorById(docid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @PutMapping("/{docid}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long docid, @RequestBody Doctor doctor) {
        try {
            Doctor updatedDoctor = doctorService.updateDoctor(docid, doctor);
            return ResponseEntity.ok(updatedDoctor);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{docid}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long docid) {
        doctorService.deleteDoctor(docid);
        return ResponseEntity.noContent().build();
    }
}
