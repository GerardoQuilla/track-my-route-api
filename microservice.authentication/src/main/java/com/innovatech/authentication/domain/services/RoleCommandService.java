package com.innovatech.authentication.domain.services;

import com.innovatech.authentication.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
