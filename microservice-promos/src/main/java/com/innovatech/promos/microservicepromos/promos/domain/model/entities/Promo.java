package com.innovatech.promos.microservicepromos.promos.domain.model.entities;

import com.innovatech.promos.microservicepromos.promos.domain.model.commands.CreatePromoCommand;
import com.innovatech.promos.microservicepromos.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "promos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Promo extends AuditableAbstractAggregateRoot<Promo> {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "valid_until")
    private Date validUntil;

    public Promo(CreatePromoCommand command) {
        this.name = command.name();
        this.description = command.description();
        this.imageUrl = command.imageUrl();
        this.validUntil = command.validUntil();
    }
}