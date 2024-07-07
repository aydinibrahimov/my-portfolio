package com.example.ms.cybernet.ingress.controller;

import com.example.ms.cybernet.ingress.model.request.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/payments")
public class PaymentController {

    @GetMapping

    public void createPayment(PaymentRequest paymentRequest) {
        return "dfcgvhbj";

    }

}
