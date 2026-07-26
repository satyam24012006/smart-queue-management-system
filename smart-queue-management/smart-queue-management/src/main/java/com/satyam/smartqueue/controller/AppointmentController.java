package com.satyam.smartqueue.controller;

import com.satyam.smartqueue.dto.AppointmentRequest;
import com.satyam.smartqueue.entity.Appointment;
import com.satyam.smartqueue.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@Validated
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Book Appointment
    @PostMapping
    public ResponseEntity<Appointment> bookAppointment(
            @Valid @RequestBody AppointmentRequest request) {

        return ResponseEntity.ok(
                appointmentService.bookAppointment(request));
    }

    // Get All Appointments
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {

        return ResponseEntity.ok(
                appointmentService.getAllAppointments());
    }

    // Get Appointment By Id
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentById(id));
    }

    // Update Appointment
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(
            @PathVariable Long id,
            @Valid @RequestBody Appointment appointment) {

        return ResponseEntity.ok(
                appointmentService.updateAppointment(id, appointment));
    }

    // Confirm Appointment
    @PutMapping("/confirm/{id}")
    public ResponseEntity<Appointment> confirmAppointment(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                appointmentService.confirmAppointment(id));
    }

    // Cancel Appointment
    @PutMapping("/{id}/cancel")
    public ResponseEntity<String> cancelAppointment(
            @PathVariable Long id) {

        appointmentService.cancelAppointment(id);

        return ResponseEntity.ok("Appointment Cancelled Successfully");
    }
}