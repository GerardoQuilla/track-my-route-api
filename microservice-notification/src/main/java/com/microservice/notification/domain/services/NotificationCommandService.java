package com.microservice.notification.domain.services;

import com.microservice.notification.domain.model.commands.CreateNotificationCommand;
import com.microservice.notification.domain.model.commands.DeleteNotificationCommand;
import com.microservice.notification.domain.model.entities.Notification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface NotificationCommandService {
    Optional<Notification> handle(CreateNotificationCommand command);
    Optional<Notification> handle(DeleteNotificationCommand command);
}
