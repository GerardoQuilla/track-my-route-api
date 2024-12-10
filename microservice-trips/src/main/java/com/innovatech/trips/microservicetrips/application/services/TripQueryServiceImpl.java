package com.innovatech.trips.microservicetrips.application.services;

import com.innovatech.trips.microservicetrips.domain.model.aggregates.Trip;
import com.innovatech.trips.microservicetrips.domain.model.queries.GetAllTripsQuery;
import com.innovatech.trips.microservicetrips.domain.model.queries.GetTripByFareQuery;
import com.innovatech.trips.microservicetrips.domain.model.queries.GetTripByIdQuery;
import com.innovatech.trips.microservicetrips.domain.model.queries.GetTripByOriginQuery;
import com.innovatech.trips.microservicetrips.domain.services.TripQueryService;
import com.innovatech.trips.microservicetrips.infrastructure.persistence.jpa.repositories.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripQueryServiceImpl implements TripQueryService {

    private final TripRepository tripRepository;

    public TripQueryServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Optional<Trip> handle(GetTripByIdQuery query) {
        return tripRepository.findById(query.id());
    }

    @Override
    public Optional<Trip> handle(GetTripByOriginQuery query) {
        return tripRepository.findByOrigin(query.origin());
    }

    @Override
    public Optional<Trip> handle(GetTripByFareQuery query) {
        return tripRepository.findByFare(query.fare());
    }

    @Override
    public List<Trip> handle(GetAllTripsQuery query) { return tripRepository.findAll(); }
}
