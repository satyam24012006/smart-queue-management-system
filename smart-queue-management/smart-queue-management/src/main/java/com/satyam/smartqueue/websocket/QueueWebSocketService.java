package com.satyam.smartqueue.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueueWebSocketService {

    private final SimpMessagingTemplate messagingTemplate;

    public QueueWebSocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendQueueUpdate(QueueUpdateMessage message) {

        messagingTemplate.convertAndSend(
                "/topic/queue",
                message
        );
    }
}
