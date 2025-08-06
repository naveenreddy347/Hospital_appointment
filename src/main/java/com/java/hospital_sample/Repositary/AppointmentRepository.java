package com.java.hospital_sample.Repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.java.hospital_sample.user.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Long>{
	List<Appointment>findByDoctor_Docid(Long docid);
	

}
