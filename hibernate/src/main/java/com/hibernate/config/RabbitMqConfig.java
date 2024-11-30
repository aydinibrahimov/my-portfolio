package com.hibernate.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    private final String paymentQ;
    private final String paymentDLQ;
    private final String paymentQExchange;
    private final String paymentDLQExchange;
    private final String paymentQKey;
    private final String paymentDLQKey;


    public RabbitMqConfig(@Value("${rabbitmq.queue.payment}") String paymentQ,
                          @Value("$(rabbitmq.queue.payment-dlq} ") String paymentDLQ) {
        this.paymentQ = paymentQ;
        this.paymentDLQ = paymentDLQ;
        this.paymentQExchange = paymentQ + "_Exchange";
        this.paymentDLQExchange = paymentDLQ + "_Exchange";
        this.paymentQKey = paymentQ + "_Key";
        this.paymentDLQKey = paymentDLQ + "_Key";
    }

    @Bean
    DirectExchange paymentDLQExchange() {
        return new DirectExchange(paymentDLQExchange);

    }

    @Bean
    DirectExchange paymentQExchange() {
        return new DirectExchange(paymentQExchange);

    }

    @Bean
    Queue paymentDLQ() {
        return QueueBuilder.durable(paymentDLQ).build();

    }

    @Bean
    Queue paymentQ() {
        return QueueBuilder.durable(paymentQ)
                .withArgument("x-deed-Letter-exchange", paymentDLQExchange)
                .withArgument("x-deod-letter-routing-key", paymentDLQKey)
                .build();
    }

    @Bean
    Binding paymentDLQBinding() {
        return BindingBuilder.bind(paymentDLQ())
                .to(paymentDLQExchange()).with(paymentDLQKey);
    } @Bean
    Binding paymentQBinding() {
        return BindingBuilder.bind(paymentQ())
                .to(paymentQExchange()).with(paymentQKey);
    }
}
