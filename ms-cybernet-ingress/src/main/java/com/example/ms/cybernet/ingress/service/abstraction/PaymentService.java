package com.example.ms.cybernet.ingress.service.abstraction;

import com.example.ms.cybernet.ingress.model.request.PaymentRequest;
import com.example.ms.cybernet.ingress.model.response.PaymentResponse;

public interface PaymentService {
    void createPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentById(Long id);

    void updatePaymentDescription(Long id, String description);

    void deletePaymentById(Long id);
}
