package com.java.hospital_sample.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.hospital_sample.user.Doctor;
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
