package com.example.ms.cybernet.ingress.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/payments")
public class PaymentController {

    @GetMapping
    @ResponseStatu("")
    public void createPayment(String message) {
        return "dfcgvhbj";

    }

}
