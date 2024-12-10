package com.innovatech.trips.microservicetrips.interfaces.rest.transform;


import com.innovatech.trips.microservicetrips.domain.model.aggregates.Trip;
import com.innovatech.trips.microservicetrips.interfaces.rest.resources.TripResource;

public class TripResourceFromEntityAssembler {
    public static TripResource transformResourceFromEntity(Trip entity) {
        return new TripResource(entity.getId(), entity.getOrigin(), entity.getDestination(), entity.getTime(), entity.getFare());
    }
}
