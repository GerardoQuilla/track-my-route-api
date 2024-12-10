package com.innovatech.microserviceprofile.profile.domain.model.entities;

import com.innovatech.microserviceprofile.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;


    public Profile(String name, String email, String phone, String address, String imageUrl, String password, String role) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.imageUrl = imageUrl;
        this.password = password;
        this.role = role;
    }
}
