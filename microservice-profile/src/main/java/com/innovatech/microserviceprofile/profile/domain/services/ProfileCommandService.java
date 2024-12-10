package com.innovatech.microserviceprofile.profile.domain.services;

import com.innovatech.microserviceprofile.profile.domain.model.commands.CreateProfileCommand;
import com.innovatech.microserviceprofile.profile.domain.model.commands.DeleteProfileCommand;
import com.innovatech.microserviceprofile.profile.domain.model.entities.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
    Optional<Profile> handle(DeleteProfileCommand command);
}
