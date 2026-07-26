package com.satyam.smartqueue.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Doctor name is required")
    private String doctorName;

    @NotBlank(message = "Doctor specialization is required")
    private String specialization;

    @NotBlank(message = "Doctor qualification is required")
    private String qualification;

    @Min(value = 0, message = "Experience cannot be negative")
    private int experience;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number")
    @Column(unique = true)
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    @Column(unique = true)
    private String emailId;

    @Min(value = 1, message = "Room number must be greater than 0")
    private int roomNumber;

    private boolean availabilityStatus;

    @Positive(message = "Consultation fee must be greater than 0")
    private double consultationFee;

    @NotBlank(message = "Shift is required")
    private String shift;

    @NotNull(message = "Department is required")
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Doctor() {
    }

    public Doctor(String doctorName, String specialization, String qualification,
                  int experience, String phoneNumber, String emailId,
                  int roomNumber, boolean availabilityStatus,
                  double consultationFee, String shift, Department department) {
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experience = experience;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.roomNumber = roomNumber;
        this.availabilityStatus = availabilityStatus;
        this.consultationFee = consultationFee;
        this.shift = shift;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", doctorName='" + doctorName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", qualification='" + qualification + '\'' +
                ", experience=" + experience +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                ", roomNumber=" + roomNumber +
                ", availabilityStatus=" + availabilityStatus +
                ", consultationFee=" + consultationFee +
                ", shift='" + shift + '\'' +
                ", department=" + department +
                '}';
    }
}