package org.ashik.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }


    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public String sendMessage(String message) {
        return message;
    }

    @MessageMapping("/chat_customer")
    @SendTo("/topic/ashik")
    public String sendMessageAlso(String message) {
        return message;
    }

    @MessageMapping("/chat_something")
    public void sendMessageToMultipleTopics(String message) {
        // Send the message to the first topic
        messagingTemplate.convertAndSend("/topic/messages", message);

        // Send the same message to the second topic
        messagingTemplate.convertAndSend("/topic/"+"123456", message);

    }
}
