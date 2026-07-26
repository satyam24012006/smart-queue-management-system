package com.satyam.smartqueue.service;

import com.satyam.smartqueue.entity.Token;

import java.util.List;

public interface TokenService {

    // Generate New Token
    Token generateToken(Token token);

    // Get All Tokens
    List<Token> getAllTokens();

    // Get Token By Id
    Token getTokenById(Long id);

    // Update Token
    Token updateToken(Long id, Token token);

    // Delete Token
    void deleteToken(Long id);

}
