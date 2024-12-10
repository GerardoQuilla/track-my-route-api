package com.innovatech.authentication.interfaces.rest.transform;

import com.innovatech.authentication.domain.model.aggregates.User;
import com.innovatech.authentication.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {

    public static AuthenticatedUserResource toResourceFromEntity(User user, String token){
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}

