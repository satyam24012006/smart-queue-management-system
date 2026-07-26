package com.satyam.smartqueue.service;
import com.satyam.smartqueue.entity.Token;
import com.satyam.smartqueue.enums.TokenStatus;
import com.satyam.smartqueue.exception.ResourceNotFoundException;
import com.satyam.smartqueue.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public Token generateToken(Token token) {

        token.setGeneratedTime(LocalDateTime.now());
        token.setStatus(TokenStatus.WAITING);

        // Generate Token Number
        String tokenNumber = "T001";

        Optional<Token> lastToken = tokenRepository.findTopByOrderByIdDesc();

        if (lastToken.isPresent()) {

            String lastNumber = lastToken.get().getTokenNumber();

            if (lastNumber != null && lastNumber.startsWith("T")) {

                int number = Integer.parseInt(lastNumber.substring(1));

                tokenNumber = String.format("T%03d", number + 1);
            }
        }

        token.setTokenNumber(tokenNumber);

        return tokenRepository.save(token);
    }

    @Override
    public List<Token> getAllTokens() {
        return tokenRepository.findAll();
    }

    @Override
    public Token getTokenById(Long id) {

        return tokenRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Token not found with id : " + id));
    }

    @Override
    public Token updateToken(Long id, Token token) {

        Token existingToken = tokenRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Token not found with id : " + id));

        existingToken.setTokenNumber(token.getTokenNumber());
        existingToken.setComplaint(token.getComplaint());
        existingToken.setPriority(token.getPriority());
        existingToken.setStatus(token.getStatus());
        existingToken.setGeneratedTime(token.getGeneratedTime());
        existingToken.setUser(token.getUser());
        existingToken.setDoctor(token.getDoctor());
        existingToken.setDepartment(token.getDepartment());

        return tokenRepository.save(existingToken);
    }

    @Override
    public void deleteToken(Long id) {

        Token token = tokenRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Token not found with id : " + id));

        tokenRepository.delete(token);
    }
}
