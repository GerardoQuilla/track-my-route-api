package com.innovatech.microserviceprofile.profile.domain.services;

import com.innovatech.microserviceprofile.profile.domain.model.entities.Profile;
import com.innovatech.microserviceprofile.profile.domain.model.queries.GetProfileByIdQuery;
import com.innovatech.microserviceprofile.profile.domain.model.queries.GetProfilesQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProfileQueryService {
    Optional<Profile> handle(GetProfileByIdQuery query);
    List<Profile> handle(GetProfilesQuery query);
}
