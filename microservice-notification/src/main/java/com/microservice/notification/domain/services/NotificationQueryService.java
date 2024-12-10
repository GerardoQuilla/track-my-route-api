package com.microservice.notification.domain.services;

import com.microservice.notification.domain.model.entities.Notification;
import com.microservice.notification.domain.model.queries.GetNotificationByIdQuery;
import com.microservice.notification.domain.model.queries.GetNotificationsQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface NotificationQueryService {
    Optional<Notification> handle(GetNotificationByIdQuery query);
    List<Notification> handle(GetNotificationsQuery query);
}
