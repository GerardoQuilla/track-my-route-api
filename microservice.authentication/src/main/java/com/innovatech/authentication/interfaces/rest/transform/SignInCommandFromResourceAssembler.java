package com.innovatech.authentication.interfaces.rest.transform;

import com.innovatech.authentication.domain.model.commands.SignInCommand;
import com.innovatech.authentication.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {

    public static SignInCommand toCommandFromResource(SignInResource resource) {
        return new SignInCommand(resource.username(), resource.password());
    }
}
