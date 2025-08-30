package com.java.hospital_sample.Repositary;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.java.hospital_sample.user.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    
	List<Prescription> findByUserId(Long userId);
    List<Prescription> findByDocId(Long docId);
    List<Prescription> findByAppointmentId(Long appointmentId);
}
