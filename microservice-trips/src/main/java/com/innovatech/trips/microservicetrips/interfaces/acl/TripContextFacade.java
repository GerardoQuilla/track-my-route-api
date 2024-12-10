package com.innovatech.trips.microservicetrips.interfaces.acl;

import com.innovatech.trips.microservicetrips.domain.model.commands.CreateTripCommand;
import com.innovatech.trips.microservicetrips.domain.model.queries.GetTripByFareQuery;
import com.innovatech.trips.microservicetrips.domain.model.queries.GetTripByIdQuery;
import com.innovatech.trips.microservicetrips.domain.model.queries.GetTripByOriginQuery;
import com.innovatech.trips.microservicetrips.domain.model.valueobjects.Fare;
import com.innovatech.trips.microservicetrips.domain.model.valueobjects.Origin;
import com.innovatech.trips.microservicetrips.domain.services.TripCommandService;
import com.innovatech.trips.microservicetrips.domain.services.TripQueryService;
import org.springframework.stereotype.Service;


@Service
public class TripContextFacade {
    private final TripCommandService tripCommandService;
    private final TripQueryService tripQueryService;

    public TripContextFacade(TripCommandService tripCommandService, TripQueryService tripQueryService) {
        this.tripCommandService = tripCommandService;
        this.tripQueryService = tripQueryService;
    }

    public Long createTrip(String origin,
                           String destination,
                           String time,
                           String fare) {
        var createTripCommand = new CreateTripCommand(origin, destination, time, fare);
        var trip = tripCommandService.handle(createTripCommand);
        if (trip.isEmpty()) return 0L;
        return trip.get().getId();
    }

    public Long fetchTripIdByFare(String fare) {
        var getTripByFareQuery = new GetTripByFareQuery(new Fare(fare));
        // Handle the query using tripQueryService
        return 0L; // Placeholder return value
    }

    public Long fetchTripIdByOrigin(String origin) {
        var getTripByOriginQuery = new GetTripByOriginQuery(new Origin(origin));
        // Handle the query using tripQueryService
        return 0L; // Placeholder return value
    }

    public Long fetchTripIdById(Long id) {
        var getTripByIdQuery = new GetTripByIdQuery(id);
        // Handle the query using tripQueryService
        return 0L; // Placeholder return value
    }
}
