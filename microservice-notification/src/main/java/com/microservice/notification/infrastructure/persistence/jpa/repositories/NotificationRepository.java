package com.microservice.notification.infrastructure.persistence.jpa.repositories;

import com.microservice.notification.domain.model.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
