package com.app.chatapp.controllers;

import com.app.chatapp.models.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {


    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage chatMessage){
        System.out.println("Received: " + chatMessage);
        return chatMessage;
    }

    @GetMapping("/")
    public String chat(){
        return "chat";
    }
}
