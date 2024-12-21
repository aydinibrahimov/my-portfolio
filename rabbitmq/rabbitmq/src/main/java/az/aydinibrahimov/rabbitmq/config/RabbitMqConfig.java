package az.aydinibrahimov.rabbitmq.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    private final String notifQ;
    private final String notifDLQ;
    private final String notifQExchange;
    private final String notifDLQExchange;
    private final String notifQKey;
    private final String notifDLQKey;


    public RabbitMqConfig(@Value("${rabbitmq.queue.notif}") String notifQ,
                          @Value("$(rabbitmq.queue.notif-dlq} ") String notifDLQ) {
        this.notifQ = notifQ;
        this.notifDLQ = notifDLQ;
        this.notifQExchange = notifQ + "_Exchange";
        this.notifDLQExchange = notifDLQ + "_Exchange";
        this.notifQKey = notifQ + "_Key";
        this.notifDLQKey = notifDLQ + "_Key";
    }

    @Bean
    DirectExchange notifDLQExchange() {
        return new DirectExchange(notifDLQExchange);

    }

    @Bean
    DirectExchange notifQExchange() {
        return new DirectExchange(notifQExchange);

    }

    @Bean
    Queue notifDLQ() {
        return QueueBuilder.durable(notifDLQ).build();

    }

    @Bean
    Queue notifQ() {
        return QueueBuilder.durable(notifQ)
                .withArgument("x-deed-Letter-exchange", notifDLQExchange)
                .withArgument("x-deod-letter-routing-key", notifDLQKey)
                .build();
    }

    @Bean
    Binding notifDLQBinding() {
        return BindingBuilder.bind(notifDLQ())
                .to(notifDLQExchange()).with(notifDLQKey);
    }

    @Bean
    Binding notifQBinding() {
        return BindingBuilder.bind(notifQ())
                .to(notifQExchange()).with(notifQKey);
    }
}
