package com.example.ms.cybernet.ingress.service;

import com.example.ms.cybernet.ingress.model.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public MessageResponse getMessage(String message) {
        return new MessageResponse(message);
    }
}
