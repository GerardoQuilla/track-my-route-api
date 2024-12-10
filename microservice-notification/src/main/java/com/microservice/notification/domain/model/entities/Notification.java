package com.microservice.notification.domain.model.entities;

import com.microservice.notification.domain.model.commands.CreateNotificationCommand;
import com.microservice.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notifications")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Notification extends AuditableAbstractAggregateRoot<Notification> {

    @Column(name = "title")
    private String title;
    @Column(name = "subtitle")
    private String subtitle;
    @Column(name = "description")
    private String description;
    @Column(name = "img_url")
    private String imgUrl;
    public Notification(CreateNotificationCommand command) {
        this.title = command.title();
        this.description = command.description();
        this.subtitle = command.subtitle();
        this.imgUrl = command.imgUrl();
    }

}
