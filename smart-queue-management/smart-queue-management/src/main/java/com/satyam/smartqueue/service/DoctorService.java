package com.satyam.smartqueue.service;

import com.satyam.smartqueue.entity.Doctor;

import java.util.List;

public interface DoctorService {

    // Add Doctor
    Doctor saveDoctor(Doctor doctor);

    // Get All Doctors
    List<Doctor> getAllDoctors();

    // Get Doctor By Id
    Doctor getDoctorById(Long id);

    // Update Doctor
    Doctor updateDoctor(Long id, Doctor doctor);

    // Delete Doctor
    void deleteDoctor(Long id);
}