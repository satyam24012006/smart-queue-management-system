package com.satyam.smartqueue.controller;

import com.satyam.smartqueue.dto.DashboardResponse;
import com.satyam.smartqueue.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<DashboardResponse> getDashboardData() {

        return ResponseEntity.ok(
                dashboardService.getDashboardData());
    }
}