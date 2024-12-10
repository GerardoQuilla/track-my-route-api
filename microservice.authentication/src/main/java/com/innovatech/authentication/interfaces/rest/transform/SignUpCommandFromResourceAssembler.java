package com.innovatech.authentication.interfaces.rest.transform;

import com.innovatech.authentication.domain.model.commands.SignUpCommand;
import com.innovatech.authentication.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {

    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        return new SignUpCommand(resource.username(), resource.password(), resource.roles());
    }
}
