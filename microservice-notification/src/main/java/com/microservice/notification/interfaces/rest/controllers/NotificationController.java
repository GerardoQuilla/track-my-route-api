package com.microservice.notification.interfaces.rest.controllers;

import com.microservice.notification.domain.model.commands.DeleteNotificationCommand;
import com.microservice.notification.domain.model.queries.GetNotificationByIdQuery;
import com.microservice.notification.domain.model.queries.GetNotificationsQuery;
import com.microservice.notification.domain.services.NotificationCommandService;
import com.microservice.notification.domain.services.NotificationQueryService;
import com.microservice.notification.interfaces.rest.resources.CreateNotificationResource;
import com.microservice.notification.interfaces.rest.resources.NotificationResource;
import com.microservice.notification.interfaces.rest.transform.CreateNotificationCommandFromResourceAssembler;
import com.microservice.notification.interfaces.rest.transform.NotificationResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "api/v1/notifications")
@Tag(name="Notifications", description = "Notification Management Endpoints")
public class NotificationController {
    private final NotificationCommandService notificationCommandService;
    private final NotificationQueryService notificationQueryService;
    public NotificationController(NotificationCommandService notificationCommandService, NotificationQueryService notificationQueryService) {
        this.notificationCommandService = notificationCommandService;
        this.notificationQueryService = notificationQueryService;
    }
    @GetMapping
    public ResponseEntity<List<NotificationResource>> getAllNotifications() {
        var notifications = notificationQueryService.handle(new GetNotificationsQuery());
        var notificationsResource = notifications.stream().map(NotificationResourceFromEntityAssembler::transformResourceFromEntity).toList();
        return ResponseEntity.ok(notificationsResource);
    }
    @GetMapping("/{id}")
    public ResponseEntity<NotificationResource> getNotificationById(@PathVariable Long id) {
        var notification = notificationQueryService.handle(new GetNotificationByIdQuery(id));
        if (notification.isEmpty()) {
            throw new IllegalArgumentException("Notification with id " + id + " not found");
        }
        var notificationResource = NotificationResourceFromEntityAssembler.transformResourceFromEntity(notification.get());
        return ResponseEntity.ok(notificationResource);
    }
    @PostMapping
    public ResponseEntity<NotificationResource> createNotification(@RequestBody CreateNotificationResource resource) {
        var createNotificationCommand = CreateNotificationCommandFromResourceAssembler.toCommandFromResource(resource);
        var notification = notificationCommandService.handle(createNotificationCommand);
        if (notification.isEmpty()) return ResponseEntity.badRequest().build();
        var notificationResource = NotificationResourceFromEntityAssembler.transformResourceFromEntity(notification.get());
        return new ResponseEntity<NotificationResource>(notificationResource, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<NotificationResource> deleteNotificationById(@PathVariable Long id) {
        var deleteNotificationCommand = new DeleteNotificationCommand(id);
        var notification = notificationCommandService.handle(deleteNotificationCommand);
        if (notification.isEmpty()) return ResponseEntity.badRequest().build();
        var notificationResource = NotificationResourceFromEntityAssembler.transformResourceFromEntity(notification.get());
        return ResponseEntity.ok(notificationResource);
    }
}
