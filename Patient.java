package com.example.clinic.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Patient")
public class Patient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PatientID")
  private Long patientId;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "UserID", nullable = false, unique = true)
  private User user;

  @Column(name = "DOB")
  private LocalDate dob;

  @Column(name = "Phone")
  private String phone;

  @Column(name = "Email")
  private String email;

  public Patient() {}

  public Long getPatientId() { return patientId; }
  public void setPatientId(Long patientId) { this.patientId = patientId; }

  public User getUser() { return user; }
  public void setUser(User user) { this.user = user; }

  public LocalDate getDob() { return dob; }
  public void setDob(LocalDate dob) { this.dob = dob; }

  public String getPhone() { return phone; }
  public void setPhone(String phone) { this.phone = phone; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
}
