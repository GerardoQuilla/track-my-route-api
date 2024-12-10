package com.innovatech.trips.microservicetrips.interfaces.rest.resources;

public record TripResource(
        Long id,
        String origin,
        String destination,
        String time,
        String fare) {
}