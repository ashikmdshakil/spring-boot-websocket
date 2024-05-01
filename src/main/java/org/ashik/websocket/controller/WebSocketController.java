package org.ashik.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }


    /*@SendTo("/topic/messages")
    @MessageMapping("/send-message")
    public String sendMessage(String message)
    {
        return message;
    }*/

    /*@MessageMapping("/chat_customer")
    @SendTo("/topic/ashik")
    public String sendMessageAlso(String message) {
        return message;
    }*/

    /*@MessageMapping("/chat_something")
    public void sendMessageToMultipleTopics(String message) {
        // Send the message to the first topic
        messagingTemplate.convertAndSend("/topic/messages", message);

        // Send the same message to the second topic
        messagingTemplate.convertAndSend("/topic/"+"123456", message);
    }*/

    /*@GetMapping(value = "sendMessage")
    @ResponseBody
    public String sendMessageToClient(@RequestParam("message") String message){
        messagingTemplate.convertAndSend("/topic/taima_rahman_mim", message);
        return "Success";
    }*/

    @MessageMapping("/chat_with_ashik")
    public void getMessageFromWeb(String message) {

    }

    public void sendMessageToTaima(String replyMessage){
        messagingTemplate.convertAndSend("/topic/taima_rahman_mim", replyMessage);
    }
}
