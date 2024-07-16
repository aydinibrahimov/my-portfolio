package com.example.ms.cybernet.ingress.mapper;

import com.example.ms.cybernet.ingress.dao.entity.PaymentEntity;
import com.example.ms.cybernet.ingress.model.request.PaymentRequest;
import com.example.ms.cybernet.ingress.model.response.PaymentResponse;

import static com.example.ms.cybernet.ingress.model.enums.PaymentStatus.DRAFT;


public enum PaymentMapper {
    PAYMENT_MAPPER;

    public PaymentEntity generatePayment(PaymentRequest request) {
        return PaymentEntity.builder()
                .paymentAmount(request.getPaymentAmount())
                .description(request.getDescription())
                .status(DRAFT)
                .build();
    }

    public PaymentResponse generatePaymentResponse(PaymentEntity payment) {
        return PaymentResponse.builder()
                .id(payment.getId())
                .paymentAmount(payment.getPaymentAmount())
                .description(payment.getDescription())
                .paymentStatus(payment.getStatus())
                .build();
    }

}
