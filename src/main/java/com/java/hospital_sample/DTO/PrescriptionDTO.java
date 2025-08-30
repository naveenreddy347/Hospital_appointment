package com.java.hospital_sample.DTO;

public class PrescriptionDTO {
    private String dosage;
    private String instructions;
    private String medication;
    private Long appointmentId;
    private Long userId;
    private Long docId;
    private String medicines;
    private String details;

    // Getters and Setters
    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }

    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }

    public String getMedication() { return medication; }
    public void setMedication(String medication) { this.medication = medication; }

    public Long getAppointmentId() { return appointmentId; }
    public void setAppointmentId(Long appointmentId) { this.appointmentId = appointmentId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getDocId() { return docId; }
    public void setDocId(Long docId) { this.docId = docId; }

    public String getMedicines() { return medicines; }
    public void setMedicines(String medicines) { this.medicines = medicines; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}
