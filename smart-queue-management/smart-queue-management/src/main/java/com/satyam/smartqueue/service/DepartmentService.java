package com.satyam.smartqueue.service;

import java.util.List;
import com.satyam.smartqueue.entity.Department;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    void deleteDepartment(Long id);

    Department updateDepartment(Long id, Department department);
}

