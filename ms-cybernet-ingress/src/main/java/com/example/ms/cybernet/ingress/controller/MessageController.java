package com.example.ms.cybernet.ingress.controller;

import com.example.ms.cybernet.ingress.model.MessageResponse;
import com.example.ms.cybernet.ingress.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/messages")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public MessageResponse getMessage(String message) {
        return messageService.getMessage(message);

    }

}
