package com.satyam.smartqueue.service;

import com.satyam.smartqueue.entity.Token;
import com.satyam.smartqueue.enums.TokenStatus;
import com.satyam.smartqueue.exception.ResourceNotFoundException;
import com.satyam.smartqueue.repository.TokenRepository;
import com.satyam.smartqueue.websocket.QueueUpdateMessage;
import com.satyam.smartqueue.websocket.QueueWebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueServiceImpl implements QueueService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private QueueWebSocketService queueWebSocketService;

    @Override
    public Token callNextToken(Long departmentId) {

        tokenRepository.findByDepartmentIdAndStatus(
                departmentId,
                TokenStatus.SERVING
        ).ifPresent(token -> {
            throw new IllegalStateException("A patient is already being served.");
        });

        List<Token> waitingTokens =
                tokenRepository.findByDepartmentIdAndStatusOrderByPriorityDescGeneratedTimeAsc(
                        departmentId,
                        TokenStatus.WAITING);

        if (waitingTokens.isEmpty()) {
            throw new ResourceNotFoundException("No waiting token found.");
        }

        Token token = waitingTokens.get(0);

        token.setStatus(TokenStatus.SERVING);

        Token savedToken = tokenRepository.save(token);

        QueueUpdateMessage message = new QueueUpdateMessage(
                "Next Token Called",
                savedToken.getId(),
                savedToken.getTokenNumber(),
                savedToken.getStatus().name(),
                departmentId
        );

        queueWebSocketService.sendQueueUpdate(message);

        return savedToken;
    }

    @Override
    public Token getCurrentServingToken(Long departmentId) {

        return tokenRepository.findByDepartmentIdAndStatus(
                departmentId,
                TokenStatus.SERVING
        ).orElseThrow(() ->
                new ResourceNotFoundException("No patient is being served."));
    }

    @Override
    public Token completeCurrentToken(Long tokenId) {

        Token token = tokenRepository.findById(tokenId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Token not found."));

        token.setStatus(TokenStatus.COMPLETED);

        Token savedToken = tokenRepository.save(token);

        QueueUpdateMessage message = new QueueUpdateMessage(
                "Token Completed",
                savedToken.getId(),
                savedToken.getTokenNumber(),
                savedToken.getStatus().name(),
                savedToken.getDepartment().getId()
        );

        queueWebSocketService.sendQueueUpdate(message);

        return savedToken;
    }

    @Override
    public Token cancelToken(Long tokenId) {

        Token token = tokenRepository.findById(tokenId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Token not found."));

        token.setStatus(TokenStatus.CANCELLED);

        Token savedToken = tokenRepository.save(token);

        QueueUpdateMessage message = new QueueUpdateMessage(
                "Token Cancelled",
                savedToken.getId(),
                savedToken.getTokenNumber(),
                savedToken.getStatus().name(),
                savedToken.getDepartment().getId()
        );

        queueWebSocketService.sendQueueUpdate(message);

        return savedToken;
    }

    @Override
    public List<Token> getWaitingQueue(Long departmentId) {

        return tokenRepository
                .findByDepartmentIdAndStatusOrderByPriorityDescGeneratedTimeAsc(
                        departmentId,
                        TokenStatus.WAITING);
    }

    @Override
    public long getQueueSize(Long departmentId) {

        return tokenRepository
                .findByDepartmentIdAndStatusOrderByPriorityDescGeneratedTimeAsc(
                        departmentId,
                        TokenStatus.WAITING)
                .size();
    }
}