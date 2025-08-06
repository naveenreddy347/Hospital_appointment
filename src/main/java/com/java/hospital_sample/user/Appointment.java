package com.java.hospital_sample.user;

import java.time.LocalDate;

import jakarta.persistence.*;


 
@Entity
@Table(name = "appointments")
public class Appointment {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private LocalDate appointmentDate;
 
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
 
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
 
    public Appointment() {}
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }
 
    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
 
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
 
    public Doctor getDoctor() {
        return doctor;
    }
 
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
 