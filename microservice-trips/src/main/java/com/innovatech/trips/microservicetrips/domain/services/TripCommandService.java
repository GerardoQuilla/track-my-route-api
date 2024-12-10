package com.innovatech.trips.microservicetrips.domain.services;

import com.innovatech.trips.microservicetrips.domain.model.aggregates.Trip;
import com.innovatech.trips.microservicetrips.domain.model.commands.CreateTripCommand;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TripCommandService {
    Optional<Trip> handle(CreateTripCommand command);
}