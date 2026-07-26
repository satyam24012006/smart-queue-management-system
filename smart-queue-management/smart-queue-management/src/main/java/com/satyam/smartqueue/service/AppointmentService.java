package com.satyam.smartqueue.service;

import com.satyam.smartqueue.dto.AppointmentRequest;
import com.satyam.smartqueue.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    // Book Appointment
    Appointment bookAppointment(AppointmentRequest request);

    // Get All Appointments
    List<Appointment> getAllAppointments();

    // Get Appointment By Id
    Appointment getAppointmentById(Long id);

    // Update Appointment
    Appointment updateAppointment(Long id, Appointment appointment);

    // Confirm Appointment
    Appointment confirmAppointment(Long id);

    // Cancel Appointment
    void cancelAppointment(Long id);
}