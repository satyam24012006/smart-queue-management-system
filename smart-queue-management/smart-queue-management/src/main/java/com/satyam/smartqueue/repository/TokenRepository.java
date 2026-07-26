package com.satyam.smartqueue.repository;

import com.satyam.smartqueue.entity.Department;
import com.satyam.smartqueue.entity.Doctor;
import com.satyam.smartqueue.entity.Token;
import com.satyam.smartqueue.enums.TokenStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    // Get all tokens of a department
    List<Token> findByDepartment(Department department);

    // Get all tokens assigned to a doctor
    List<Token> findByDoctor(Doctor doctor);

    // Get all tokens by status
    List<Token> findByStatus(TokenStatus status);

    // Get all waiting tokens of a department
    List<Token> findByDepartmentAndStatus(Department department,
                                          TokenStatus status);

    // Count waiting tokens in a department
    long countByDepartmentAndStatus(Department department,
                                    TokenStatus status);
    // Get all waiting tokens of a department in FIFO order
    List<Token> findByDepartmentIdAndStatusOrderByPriorityDescGeneratedTimeAsc(
            Long departmentId,
            TokenStatus status);

    // Get currently serving token of a department
    Optional<Token> findByDepartmentIdAndStatus(
            Long departmentId,
            TokenStatus status);
    // Get Last Generated Token
    Optional<Token> findTopByOrderByIdDesc();
}
