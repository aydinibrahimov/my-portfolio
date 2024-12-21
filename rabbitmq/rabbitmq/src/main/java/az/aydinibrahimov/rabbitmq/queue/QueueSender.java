package az.aydinibrahimov.rabbitmq.queue;


import az.aydinibrahimov.rabbitmq.request.NotifRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueueSender {

    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void sendMessageToQ(NotifRequest request) {
        amqpTemplate.convertAndSend("NOTIF_Q", objectMapper.writeValueAsBytes(request));
    }

}
