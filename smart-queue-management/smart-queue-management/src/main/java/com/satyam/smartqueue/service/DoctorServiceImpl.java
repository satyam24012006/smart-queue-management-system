package com.satyam.smartqueue.service;

import com.satyam.smartqueue.entity.Doctor;
import com.satyam.smartqueue.exception.ResourceNotFoundException;
import com.satyam.smartqueue.repository.DoctorRepository;
import com.satyam.smartqueue.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Doctor not found with id : " + id));
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {

        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Doctor not found with id : " + id));

        existingDoctor.setDoctorName(doctor.getDoctorName());
        existingDoctor.setSpecialization(doctor.getSpecialization());
        existingDoctor.setQualification(doctor.getQualification());
        existingDoctor.setExperience(doctor.getExperience());
        existingDoctor.setPhoneNumber(doctor.getPhoneNumber());
        existingDoctor.setEmailId(doctor.getEmailId());
        existingDoctor.setRoomNumber(doctor.getRoomNumber());
        existingDoctor.setAvailabilityStatus(doctor.isAvailabilityStatus());
        existingDoctor.setConsultationFee(doctor.getConsultationFee());
        existingDoctor.setShift(doctor.getShift());
        existingDoctor.setDepartment(doctor.getDepartment());

        return doctorRepository.save(existingDoctor);
    }

    @Override
    public void deleteDoctor(Long id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Doctor not found with id : " + id));

        doctorRepository.delete(doctor);
    }
}