package com.microservice.notification.interfaces.rest.transform;

import com.microservice.notification.domain.model.commands.CreateNotificationCommand;
import com.microservice.notification.interfaces.rest.resources.CreateNotificationResource;

public class CreateNotificationCommandFromResourceAssembler {
    public static CreateNotificationCommand toCommandFromResource(CreateNotificationResource resource) {
        return new CreateNotificationCommand(
                resource.title(),
                resource.subtitle(),
                resource.description(),
                resource.img_url()
        );
    }
}
