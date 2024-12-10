package com.microservice.notification.application.internal;

import com.microservice.notification.domain.model.commands.CreateNotificationCommand;
import com.microservice.notification.domain.model.commands.DeleteNotificationCommand;
import com.microservice.notification.domain.model.entities.Notification;
import com.microservice.notification.domain.services.NotificationCommandService;
import com.microservice.notification.infrastructure.persistence.jpa.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationCommandServiceImpl implements NotificationCommandService {
    private final NotificationRepository notificationRepository;
    public NotificationCommandServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }
    @Override
    public Optional<Notification> handle(CreateNotificationCommand command) {
        var notification = new Notification(command);
        notificationRepository.save(notification);
        return Optional.of(notification);
    }
    @Override
    public Optional<Notification> handle(DeleteNotificationCommand command) {
        var notification = notificationRepository.findById(command.id());
        if (notification.isEmpty()) {
            throw new IllegalArgumentException("Notification with id " + command.id() + " not found");
        }
        notificationRepository.delete(notification.get());
        return notification;
    }
}
