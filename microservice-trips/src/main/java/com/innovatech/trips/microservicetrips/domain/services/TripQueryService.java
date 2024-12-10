package com.innovatech.trips.microservicetrips.domain.services;

import com.innovatech.trips.microservicetrips.domain.model.aggregates.Trip;
import com.innovatech.trips.microservicetrips.domain.model.queries.GetAllTripsQuery;
import com.innovatech.trips.microservicetrips.domain.model.queries.GetTripByFareQuery;
import com.innovatech.trips.microservicetrips.domain.model.queries.GetTripByIdQuery;
import com.innovatech.trips.microservicetrips.domain.model.queries.GetTripByOriginQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TripQueryService {
    Optional<Trip> handle(GetTripByIdQuery query);
    Optional<Trip> handle(GetTripByOriginQuery query);
    Optional<Trip> handle(GetTripByFareQuery query);
    List<Trip> handle(GetAllTripsQuery query);
}
