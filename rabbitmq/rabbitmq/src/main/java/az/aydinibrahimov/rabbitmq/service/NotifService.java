package az.aydinibrahimov.rabbitmq.service;


import az.aydinibrahimov.rabbitmq.model.Notification;
import az.aydinibrahimov.rabbitmq.queue.QueueSender;
import az.aydinibrahimov.rabbitmq.repository.NotificationRepository;
import az.aydinibrahimov.rabbitmq.request.NotifRequest;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotifService {

    private final NotificationRepository notifRepository;
    private final QueueSender queueSender;


    public void createNotification(NotifRequest request) {
        Notification notification = new Notification();
        notification.setSubject(request.getSubject());
        notification.setContent(request.getContent());
        notifRepository.save(notification);
    }

    @PostConstruct
    public void executeIt(){
        queueSender.sendMessageToQ(new NotifRequest("email","Bla bla bla"));
    }
}
