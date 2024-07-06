package com.example.ms.cybernet.ingress.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/messages")
public class MessageController {

    @GetMapping
    public String getMessage(String message) {
        return "dfcgvhbj";

    }

}
