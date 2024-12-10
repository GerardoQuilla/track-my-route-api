package com.innovatech.microserviceprofile.profile.interfaces;


import com.innovatech.microserviceprofile.profile.domain.model.commands.DeleteProfileCommand;
import com.innovatech.microserviceprofile.profile.domain.model.entities.Profile;
import com.innovatech.microserviceprofile.profile.domain.model.queries.GetProfilesQuery;
import com.innovatech.microserviceprofile.profile.domain.services.ProfileCommandService;
import com.innovatech.microserviceprofile.profile.domain.services.ProfileQueryService;
import com.innovatech.microserviceprofile.profile.interfaces.rest.resources.CreateProfileResource;
import com.innovatech.microserviceprofile.profile.interfaces.rest.resources.ProfileResource;
import com.innovatech.microserviceprofile.profile.interfaces.rest.transform.CreateProfileCommandFromResourceAssembler;
import com.innovatech.microserviceprofile.profile.interfaces.rest.transform.ProfileResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/profiles")
@Tag(name="Profiles", description = "Profiles Management Endpoints")
public class ProfileController {

    public ProfileController(ProfileQueryService profileQueryService, ProfileCommandService profileCommandService) {
        this.profileQueryService = profileQueryService;
        this.profileCommandService = profileCommandService;
    }

    private final ProfileQueryService profileQueryService;
    private final ProfileCommandService profileCommandService;


    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        var profiles = profileQueryService.handle(new GetProfilesQuery());
        return ResponseEntity.ok(profiles);
    }

    @PostMapping
    public ResponseEntity<ProfileResource> createProfile(@RequestBody CreateProfileResource createProfileResource) {
        var createProfileCommand = CreateProfileCommandFromResourceAssembler.toCommandFromResource(createProfileResource);
        var profile = profileCommandService.handle(createProfileCommand);

        if(profile.isEmpty()) return ResponseEntity.badRequest().build();

        var profileResource = ProfileResourceFromEntityAssembler.transformResourceFromEntity(profile.get());
        return new ResponseEntity<ProfileResource>(profileResource, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<ProfileResource> deletePromo(@RequestParam Long profileId) {
        var deleteProfileCommand = new DeleteProfileCommand(profileId);
        var profile = profileCommandService.handle(deleteProfileCommand);

        if(profile.isEmpty()) return ResponseEntity.badRequest().build();

        var profileResource = ProfileResourceFromEntityAssembler.transformResourceFromEntity(profile.get());
        return new ResponseEntity<ProfileResource>(profileResource, HttpStatus.CREATED);
    }

}
