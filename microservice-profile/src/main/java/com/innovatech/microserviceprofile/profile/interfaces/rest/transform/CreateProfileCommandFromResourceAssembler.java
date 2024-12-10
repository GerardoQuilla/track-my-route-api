package com.innovatech.microserviceprofile.profile.interfaces.rest.transform;

import com.innovatech.microserviceprofile.profile.domain.model.commands.CreateProfileCommand;
import com.innovatech.microserviceprofile.profile.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource){
        return new CreateProfileCommand( resource.name(), resource.email(), resource.phone(), resource.address(), resource.imageUrl(), resource.password(), resource.role());
    }
}
