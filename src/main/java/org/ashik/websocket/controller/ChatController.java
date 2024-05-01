package org.ashik.websocket.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ashik.websocket.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(SimpMessagingTemplate simpMessagingTemplate){
        this.messagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/client_chat")
    public void getMessageFromClient(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ChatMessage chatMessage = objectMapper.readValue(message, ChatMessage.class);
            messagingTemplate.convertAndSend("/topic/".concat(chatMessage.getChannelId()), chatMessage.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
