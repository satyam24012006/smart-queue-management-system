package com.satyam.smartqueue.service;
import com.satyam.smartqueue.entity.Token;

import java.util.List;

public interface QueueService {

    // Call Next Patient
    Token callNextToken(Long departmentId);

    // Get Current Serving Patient
    Token getCurrentServingToken(Long departmentId);

    // Complete Current Token
    Token completeCurrentToken(Long tokenId);

    // Cancel Token
    Token cancelToken(Long tokenId);

    // Get Waiting Queue
    List<Token> getWaitingQueue(Long departmentId);

    // Get Queue Size
    long getQueueSize(Long departmentId);
}
