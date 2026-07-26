package com.satyam.smartqueue.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Department name is required")
    @Column(nullable = false, unique = true)
    private String departmentName;

    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "Department code is required")
    @Column(nullable = false, unique = true, length = 5)
    private String departmentCode;
    public Department() {

    }
    public Department(String departmentName,
                      String departmentCode,
                      String description) {

        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.description = description;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }
    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDescription() {
        return description;
    }
}
