package com.example.ms.cybernet.ingress.service.concrete;

import com.example.ms.cybernet.ingress.model.request.PaymentRequest;
import com.example.ms.cybernet.ingress.model.response.PaymentResponse;
import com.example.ms.cybernet.ingress.service.abstraction.PaymentService;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public void createPayment(PaymentRequest paymentRequest) {

    }

    @Override
    public PaymentResponse getPaymentById(Long id) {
        return null;
    }

    @Override
    public void updatePaymentDescription(Long id, String description) {

    }
}
