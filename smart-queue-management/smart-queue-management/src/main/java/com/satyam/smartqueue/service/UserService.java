package com.satyam.smartqueue.service;

import com.satyam.smartqueue.dto.LoginRequest;
import com.satyam.smartqueue.dto.LoginResponse;
import com.satyam.smartqueue.entity.User;

import java.util.List;

public interface UserService {

    // Register User
    User registerUser(User user);

    // Login User
    LoginResponse loginUser(LoginRequest request);

    // Get All Users
    List<User> getAllUsers();

    // Get User By Id
    User getUserById(Long id);

    // Update User
    User updateUser(Long id, User user);

    // Delete User
    void deleteUser(Long id);
}