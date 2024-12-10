package com.microservice.notification.interfaces.rest.transform;

import com.microservice.notification.domain.model.entities.Notification;
import com.microservice.notification.interfaces.rest.resources.NotificationResource;

public class NotificationResourceFromEntityAssembler {
    public static NotificationResource transformResourceFromEntity(Notification notification) {
        return new NotificationResource(
                notification.getId(),
                notification.getTitle(),
                notification.getSubtitle(),
                notification.getDescription(),
                notification.getImgUrl()
        );
    }
}
