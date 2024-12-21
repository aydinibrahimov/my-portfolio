package az.aydinibrahimov.rabbitmq.repository;

import az.aydinibrahimov.rabbitmq.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
