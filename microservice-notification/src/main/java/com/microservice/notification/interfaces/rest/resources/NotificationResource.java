package com.microservice.notification.interfaces.rest.resources;

public record NotificationResource(
        Long id,
        String title,
        String subtitle,
        String description,
        String img_url
) {
}
