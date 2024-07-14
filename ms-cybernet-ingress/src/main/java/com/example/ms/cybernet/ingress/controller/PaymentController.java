package com.example.ms.cybernet.ingress.controller;

import com.example.ms.cybernet.ingress.model.request.PaymentRequest;
import com.example.ms.cybernet.ingress.model.response.PaymentResponse;
import com.example.ms.cybernet.ingress.service.abstraction.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPayment(PaymentRequest paymentRequest) {
        paymentService.createPayment(paymentRequest);

    }

    @GetMapping("/{id}")
    public PaymentResponse fetchPaymentById(@PathVariable Long id){
        return paymentService.getPaymentById(id);
    }
}
