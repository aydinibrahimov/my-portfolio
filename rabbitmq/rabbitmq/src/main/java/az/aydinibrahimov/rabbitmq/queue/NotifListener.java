package az.aydinibrahimov.rabbitmq.queue;


import az.aydinibrahimov.rabbitmq.request.NotifRequest;
import az.aydinibrahimov.rabbitmq.service.NotifService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotifListener {

    private final NotifService notifService;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @RabbitListener(queues = "NOTIF_Q")
    public void consume(String data) {
        var notifRequest = objectMapper.readValue(data, NotifRequest.class);
        notifService.createNotification(notifRequest);
    }
}
