package com.hibernate.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hibernate.requests.CreatePaymentRequest;
import com.hibernate.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentListener {

    private final PaymentService paymentService;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "PAYMENT_Q")
    @SneakyThrows
    public void consume(String data) {
        var paymentRequest = objectMapper.readValue(data, CreatePaymentRequest.class);
        paymentService.createPayment(paymentRequest);
    }
}
