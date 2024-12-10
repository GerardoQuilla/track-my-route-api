package com.innovatech.microserviceprofile.profile.application.internal;

import com.innovatech.microserviceprofile.profile.domain.model.entities.Profile;
import com.innovatech.microserviceprofile.profile.domain.model.queries.GetProfileByIdQuery;
import com.innovatech.microserviceprofile.profile.domain.model.queries.GetProfilesQuery;
import com.innovatech.microserviceprofile.profile.domain.services.ProfileQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {
    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return Optional.empty();
    }

    @Override
    public List<Profile> handle(GetProfilesQuery query) {
        return List.of();
    }
}
