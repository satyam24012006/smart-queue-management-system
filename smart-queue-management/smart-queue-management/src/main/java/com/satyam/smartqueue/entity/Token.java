package com.satyam.smartqueue.entity;

import com.satyam.smartqueue.enums.Priority;
import com.satyam.smartqueue.enums.TokenStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Token number is required")
    @Column(nullable = false, unique = true)
    private String tokenNumber;

    @NotBlank(message = "Complaint is required")
    @Column(nullable = false, length = 500)
    private String complaint;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TokenStatus status;

    @Column(nullable = false)
    private LocalDateTime generatedTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Long getId() {
        return id;
    }

    public String getTokenNumber() {
        return tokenNumber;
    }

    public String getComplaint() {
        return complaint;
    }

    public Priority getPriority() {
        return priority;
    }

    public TokenStatus getStatus() {
        return status;
    }

    public LocalDateTime getGeneratedTime() {
        return generatedTime;
    }

    public User getUser() {
        return user;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Department getDepartment() {
        return department;
    }

    public void setTokenNumber(String tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setStatus(TokenStatus status) {
        this.status = status;
    }

    public void setGeneratedTime(LocalDateTime generatedTime) {
        this.generatedTime = generatedTime;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}