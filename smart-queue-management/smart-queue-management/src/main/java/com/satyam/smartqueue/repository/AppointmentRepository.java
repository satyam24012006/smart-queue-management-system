package com.satyam.smartqueue.repository;

import com.satyam.smartqueue.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;



@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    long countByAppointmentDate(LocalDate appointmentDate);

}
