//package com.java.hospital_sample.Repositary;
//
//import java.time.LocalDate;
//import java.util.List;
//
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//
//import com.java.hospital_sample.user.Appointment;
//import com.java.hospital_sample.user.Doctor;
//
//
//
//public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
//    List<Appointment> findByDoctor_Docid(Long docid);
//    List<Appointment> findByUser_Userid(Long userid);
//    List<Appointment> findByDoctorAndAppointmentDate(Doctor doctor, LocalDate appointmentDate);
//
//
//}
package com.java.hospital_sample.Repositary;
 
import com.java.hospital_sample.user.Appointment;
import com.java.hospital_sample.user.Doctor;
import com.java.hospital_sample.user.User;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
 
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
 
List<Appointment> findByUser(User user);
 
 
    List<Appointment> findByDoctor_Docid(Long docid);
 
    List<Appointment> findByDoctorAndAppointmentDate(Doctor doctor, LocalDate appointmentDate);
 
    int countByDoctorAndAppointmentDate(Doctor doctor, LocalDate appointmentDate);
 



}