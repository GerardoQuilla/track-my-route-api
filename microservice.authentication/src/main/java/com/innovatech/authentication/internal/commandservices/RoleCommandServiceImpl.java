package com.innovatech.authentication.internal.commandservices;

import org.springframework.stereotype.Service;
import com.innovatech.authentication.domain.model.commands.SeedRolesCommand;
import com.innovatech.authentication.domain.model.entities.Role;
import com.innovatech.authentication.domain.model.valueobjects.Roles;
import com.innovatech.authentication.domain.services.RoleCommandService;
import com.innovatech.authentication.infrastructure.persistence.jpa.repositories.RoleRepository;

import java.util.Arrays;

@Service
public class RoleCommandServiceImpl implements RoleCommandService {
    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void handle(SeedRolesCommand command) {
        Arrays.stream(Roles.values()).forEach(role -> {
            if(!roleRepository.existsByName(role)) {
                roleRepository.save(new Role(Roles.valueOf(role.name())));
            }
        });
    }
}
