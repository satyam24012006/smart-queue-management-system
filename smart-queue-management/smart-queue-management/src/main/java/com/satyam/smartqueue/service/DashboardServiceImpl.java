package com.satyam.smartqueue.service;

import com.satyam.smartqueue.dto.DashboardResponse;
import com.satyam.smartqueue.enums.TokenStatus;
import com.satyam.smartqueue.repository.AppointmentRepository;
import com.satyam.smartqueue.repository.DepartmentRepository;
import com.satyam.smartqueue.repository.DoctorRepository;
import com.satyam.smartqueue.repository.TokenRepository;
import com.satyam.smartqueue.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public DashboardResponse getDashboardData() {

        DashboardResponse response = new DashboardResponse();

        response.setTotalUsers(userRepository.count());

        response.setTotalDoctors(doctorRepository.count());

        response.setTotalDepartments(departmentRepository.count());

        response.setTotalAppointments(appointmentRepository.count());

        // Abhi temporary
        response.setTodaysAppointments(
                appointmentRepository.countByAppointmentDate(LocalDate.now()));

        response.setWaitingTokens(
                tokenRepository.findByStatus(TokenStatus.WAITING).size());

        response.setServingTokens(
                tokenRepository.findByStatus(TokenStatus.SERVING).size());

        response.setCompletedTokens(
                tokenRepository.findByStatus(TokenStatus.COMPLETED).size());

        response.setCancelledTokens(
                tokenRepository.findByStatus(TokenStatus.CANCELLED).size());

        return response;
    }
}