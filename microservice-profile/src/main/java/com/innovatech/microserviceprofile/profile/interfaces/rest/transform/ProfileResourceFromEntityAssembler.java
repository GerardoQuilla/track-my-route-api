package com.innovatech.microserviceprofile.profile.interfaces.rest.transform;

import com.innovatech.microserviceprofile.profile.domain.model.entities.Profile;
import com.innovatech.microserviceprofile.profile.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource transformResourceFromEntity(Profile entity){
        return new ProfileResource(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getAddress(),
                entity.getImageUrl(),
                entity.getPassword(),
                entity.getRole());
    }
}
