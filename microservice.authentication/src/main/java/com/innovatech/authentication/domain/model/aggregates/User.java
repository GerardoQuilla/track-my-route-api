package com.innovatech.authentication.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import com.innovatech.authentication.domain.model.entities.Role;
import com.innovatech.authentication.shared.model.aggregate.AuditableAbstractAggregateRoot;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends AuditableAbstractAggregateRoot<User> {
    @NotBlank
    @Size(min = 3, max = 50)
    @Column(unique = true)
    private String username;

    @NotBlank
    @Size(min = 3, max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "user_has_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public User() { this.roles = new HashSet<>(); }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.roles = new HashSet<>();
    }

    public User(String username, String password, List<Role> roles) {
        this(username, password);
        addRoles(roles);
    }

    public User addRoles(List<Role> roles) {
        this.roles.addAll(roles);
        return this;
    }
}
