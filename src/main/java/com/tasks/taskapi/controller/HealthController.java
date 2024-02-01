package com.tasks.taskapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<String> getHealthStatus() {
        return ResponseEntity.status(HttpStatus.OK).body("im healthy (:");
    }
    
}
