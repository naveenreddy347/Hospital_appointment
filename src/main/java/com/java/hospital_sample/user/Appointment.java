//package com.java.hospital_sample.user;
//
//import jakarta.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "appointments")
//public class Appointment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "userid")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "docid")
//    private Doctor doctor;
//
//    @Column(name = "appointment_date")
//    private LocalDate appointmentDate;
//
//    public Appointment() {}
//
//    public Appointment(User user, Doctor doctor) {
//        this.user = user;
//        this.doctor = doctor;
//        this.appointmentDate = LocalDate.now();
//    }
//
//    // Getters and setters
//    public Long getId() { return id; }
//
//    public User getUser() { return user; }
//    public void setUser(User user) { this.user = user; }
//
//    public Doctor getDoctor() { return doctor; }
//    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
//
//    public LocalDate getAppointmentDate() { return appointmentDate; }
//    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }
//}
package com.java.hospital_sample.user;
 
import jakarta.persistence.*;
import java.time.LocalDate;
 
@Entity
@Table(name="appointment")
public class Appointment {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;
 
    @ManyToOne
    @JoinColumn(name = "docid")
    private Doctor doctor;
 
    private LocalDate appointmentDate;
 
    @Column(name = "appointment_no")
    private int appointmentNo;

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
 
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
 
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
 
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }
 
    public int getAppointmentNo() { return appointmentNo; }
    public void setAppointmentNo(int appointmentNo) { this.appointmentNo = appointmentNo; }
}