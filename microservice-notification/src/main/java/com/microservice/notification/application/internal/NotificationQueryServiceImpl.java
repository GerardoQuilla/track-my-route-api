package com.microservice.notification.application.internal;

import com.microservice.notification.domain.model.entities.Notification;
import com.microservice.notification.domain.model.queries.GetNotificationByIdQuery;
import com.microservice.notification.domain.model.queries.GetNotificationsQuery;
import com.microservice.notification.domain.services.NotificationQueryService;
import com.microservice.notification.infrastructure.persistence.jpa.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationQueryServiceImpl implements NotificationQueryService {
    private final NotificationRepository notificationRepository;
    public NotificationQueryServiceImpl(final NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }
    @Override
    public Optional<Notification> handle(GetNotificationByIdQuery query) {
        return notificationRepository.findById(query.id());
    }
    @Override
    public List<Notification> handle(GetNotificationsQuery query) {
        return notificationRepository.findAll();
    }
}
