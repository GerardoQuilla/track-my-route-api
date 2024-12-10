package com.innovatech.trips.microservicetrips.application.services;

import com.innovatech.trips.microservicetrips.domain.model.aggregates.Trip;
import com.innovatech.trips.microservicetrips.domain.model.commands.CreateTripCommand;
import com.innovatech.trips.microservicetrips.domain.services.TripCommandService;
import com.innovatech.trips.microservicetrips.infrastructure.persistence.jpa.repositories.TripRepository;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class TripCommandServiceImpl implements TripCommandService {

    private final TripRepository tripRepository;

    public TripCommandServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Optional<Trip> handle(CreateTripCommand command) {

        var trip = new Trip(command);
        tripRepository.save(trip);

        return Optional.of(trip);
    }
}
