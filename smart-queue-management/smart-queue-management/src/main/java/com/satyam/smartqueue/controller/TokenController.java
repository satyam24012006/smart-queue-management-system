package com.satyam.smartqueue.controller;
import com.satyam.smartqueue.entity.Token;
import com.satyam.smartqueue.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tokens")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    // Generate Token
    @PostMapping
    public ResponseEntity<Token> generateToken(@Valid @RequestBody Token token) {
        return new ResponseEntity<>(tokenService.generateToken(token), HttpStatus.CREATED);
    }

    // Get All Tokens
    @GetMapping
    public ResponseEntity<List<Token>> getAllTokens() {
        return ResponseEntity.ok(tokenService.getAllTokens());
    }

    // Get Token By Id
    @GetMapping("/{id}")
    public ResponseEntity<Token> getTokenById(@PathVariable Long id) {
        return ResponseEntity.ok(tokenService.getTokenById(id));
    }

    // Update Token
    @PutMapping("/{id}")
    public ResponseEntity<Token> updateToken(@PathVariable Long id,
                                             @Valid @RequestBody Token token) {
        return ResponseEntity.ok(tokenService.updateToken(id, token));
    }

    // Delete Token
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteToken(@PathVariable Long id) {

        tokenService.deleteToken(id);

        return ResponseEntity.ok("Token deleted successfully.");
    }
}
