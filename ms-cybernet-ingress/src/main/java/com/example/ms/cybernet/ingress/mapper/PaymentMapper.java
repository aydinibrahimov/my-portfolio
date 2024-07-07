package com.example.ms.cybernet.ingress.mapper;

import com.example.ms.cybernet.ingress.dao.entity.PaymentEntity;
import com.example.ms.cybernet.ingress.model.request.PaymentRequest;
import com.example.ms.cybernet.ingress.model.response.PaymentResponse;

import static com.example.ms.cybernet.ingress.model.enums.PaymentStatus.DRAFT;


public enum PaymentMapper {
    PAYMENT_MAPPER;

    public PaymentEntity convertToPayment(PaymentRequest request) {
        return PaymentEntity.builder()
                .paymentAmount(request.getPaymentAmount())
                .description(request.getDescription())
                .paymentStatus(DRAFT)
                .build();
    }

    public PaymentResponse convertToPayment(PaymentEntity payment) {
        return PaymentResponse.builder()
                .id(payment.getId())
                .paymentAmount(payment.getPaymentAmount())
                .description(payment.getDescription())
                .paymentStatus(DRAFT)
                .build();
    }

}
