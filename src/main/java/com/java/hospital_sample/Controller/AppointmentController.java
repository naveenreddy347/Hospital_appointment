
package com.java.hospital_sample.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.java.hospital_sample.Repositary.AppointmentRepository;
import com.java.hospital_sample.Repositary.DoctorRepository;
import com.java.hospital_sample.Repositary.UserRepositary;
import com.java.hospital_sample.user.Appointment;
import com.java.hospital_sample.user.Doctor;
import com.java.hospital_sample.user.User;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
 
    @Autowired
    private AppointmentRepository appointmentRepo;
 
    @Autowired
    private UserRepositary userRepo;
 
    @Autowired
    private DoctorRepository doctorRepo;
 
    // User books appointment
    @PostMapping("/book")
    public String bookAppointment(@RequestParam int userid,
                                   @RequestParam Long docid) {
        User user = userRepo.findById(userid).orElse(null);
        Doctor doctor = doctorRepo.findById(docid).orElse(null);
 
        if (user == null || doctor == null) {
            return "Invalid user or doctor ID.";
        }
 
        Appointment appointment = new Appointment();
        appointment.setUser(user);
        appointment.setDoctor(doctor);
appointment.setAppointmentDate(LocalDate.now());
 
appointmentRepo.save(appointment);
        return "Appointment booked!";
    }
 
    // Doctor views all appointments
    @GetMapping("/doctor/{docid}")
    public List<Appointment> getDoctorAppointments(@PathVariable Long docid) {
        return appointmentRepo.findByDoctor_Docid(docid);
    }
}