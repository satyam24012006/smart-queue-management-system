package com.satyam.smartqueue.controller;

import com.satyam.smartqueue.entity.Token;
import com.satyam.smartqueue.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/queue")
public class QueueController {

    @Autowired
    private QueueService queueService;

    // Call Next Patient
    @PutMapping("/call-next/{departmentId}")
    public ResponseEntity<Token> callNextToken(
            @PathVariable Long departmentId) {

        return ResponseEntity.ok(
                queueService.callNextToken(departmentId));
    }

    // Current Serving Patient
    @GetMapping("/current/{departmentId}")
    public ResponseEntity<Token> getCurrentServingToken(
            @PathVariable Long departmentId) {

        return ResponseEntity.ok(
                queueService.getCurrentServingToken(departmentId));
    }

    // Complete Current Token
    @PutMapping("/complete/{tokenId}")
    public ResponseEntity<Token> completeCurrentToken(
            @PathVariable Long tokenId) {

        return ResponseEntity.ok(
                queueService.completeCurrentToken(tokenId));
    }

    // Cancel Token
    @PutMapping("/cancel/{tokenId}")
    public ResponseEntity<Token> cancelToken(
            @PathVariable Long tokenId) {

        return ResponseEntity.ok(
                queueService.cancelToken(tokenId));
    }

    // Waiting Queue
    @GetMapping("/waiting/{departmentId}")
    public ResponseEntity<List<Token>> getWaitingQueue(
            @PathVariable Long departmentId) {

        return ResponseEntity.ok(
                queueService.getWaitingQueue(departmentId));
    }

    // Queue Size
    @GetMapping("/size/{departmentId}")
    public ResponseEntity<Long> getQueueSize(
            @PathVariable Long departmentId) {

        return ResponseEntity.ok(
                queueService.getQueueSize(departmentId));
    }
}