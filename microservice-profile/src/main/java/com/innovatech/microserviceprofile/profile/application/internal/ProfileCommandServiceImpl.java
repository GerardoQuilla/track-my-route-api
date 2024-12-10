package com.innovatech.microserviceprofile.profile.application.internal;

import com.innovatech.microserviceprofile.profile.domain.model.commands.CreateProfileCommand;
import com.innovatech.microserviceprofile.profile.domain.model.commands.DeleteProfileCommand;
import com.innovatech.microserviceprofile.profile.domain.model.entities.Profile;
import com.innovatech.microserviceprofile.profile.domain.services.ProfileCommandService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {

    @Override
    public Optional<Profile> handle(CreateProfileCommand command) {
        return Optional.empty();
    }

    @Override
    public Optional<Profile> handle(DeleteProfileCommand command) {
        return Optional.empty();
    }
}
