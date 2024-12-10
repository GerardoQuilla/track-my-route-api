package com.innovatech.trips.microservicetrips.interfaces.rest.transform;


import com.innovatech.trips.microservicetrips.domain.model.commands.CreateTripCommand;
import com.innovatech.trips.microservicetrips.interfaces.rest.resources.CreateTripResource;

public class CreateTripCommandFromResourceAssembler {
    public static CreateTripCommand toCommandFromResource(CreateTripResource resource) {
        return new CreateTripCommand(
                resource.origin(),
                resource.destination(),
                resource.time(),
                resource.fare()
        );
    }
}
