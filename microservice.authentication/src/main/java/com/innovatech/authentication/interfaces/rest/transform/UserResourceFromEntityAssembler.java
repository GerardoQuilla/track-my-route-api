package com.innovatech.authentication.interfaces.rest.transform;

import com.innovatech.authentication.domain.model.aggregates.User;
import com.innovatech.authentication.domain.model.entities.Role;
import com.innovatech.authentication.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity){
        var roles = entity.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(entity.getId(), entity.getUsername(), roles);
    }
}
