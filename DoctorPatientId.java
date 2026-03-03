package com.example.clinic.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "DoctorPatient")
public class DoctorPatient {

  @EmbeddedId
  private DoctorPatientId id;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("doctorId")
  @JoinColumn(name = "DoctorID", nullable = false)
  private Doctor doctor;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("patientId")
  @JoinColumn(name = "PatientID", nullable = false)
  private Patient patient;

  @Column(name = "AssignedAt")
  private Instant assignedAt;

  public DoctorPatient() {}

  public DoctorPatient(Doctor doctor, Patient patient) {
    this.doctor = doctor;
    this.patient = patient;
    this.assignedAt = Instant.now();
    this.id = new DoctorPatientId(doctor.getDoctorId(), patient.getPatientId());
  }

  public DoctorPatientId getId() { return id; }
  public void setId(DoctorPatientId id) { this.id = id; }

  public Doctor getDoctor() { return doctor; }
  public void setDoctor(Doctor doctor) { this.doctor = doctor; }

  public Patient getPatient() { return patient; }
  public void setPatient(Patient patient) { this.patient = patient; }

  public Instant getAssignedAt() { return assignedAt; }
  public void setAssignedAt(Instant assignedAt) { this.assignedAt = assignedAt; }
}
