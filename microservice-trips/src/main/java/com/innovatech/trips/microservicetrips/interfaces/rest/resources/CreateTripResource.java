package com.innovatech.trips.microservicetrips.interfaces.rest.resources;

public record CreateTripResource(String origin,
                                 String destination,
                                 String time,
                                 String fare) {
}