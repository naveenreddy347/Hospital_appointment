package com.java.hospital_sample.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hospital_sample.Repositary.DoctorRepository;
import com.java.hospital_sample.user.Doctor;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long docid) {
        return doctorRepository.findById(docid);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long docid, Doctor updatedDoctor) {
        return doctorRepository.findById(docid)
                .map(doctor -> {
                    doctor.setName(updatedDoctor.getName());
                    doctor.setDesignation(updatedDoctor.getDesignation());
                    return doctorRepository.save(doctor);
                })
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }


    public void deleteDoctor(Long docid) {
        doctorRepository.deleteById(docid);
    }
}
