package com.innovatech.authentication.interfaces.rest.transform;

import com.innovatech.authentication.domain.model.entities.Role;
import com.innovatech.authentication.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
