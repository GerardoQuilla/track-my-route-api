package com.innovatech.trips.microservicetrips.infrastructure.persistence.jpa.repositories;

import com.innovatech.trips.microservicetrips.domain.model.aggregates.Trip;
import com.innovatech.trips.microservicetrips.domain.model.valueobjects.Fare;
import com.innovatech.trips.microservicetrips.domain.model.valueobjects.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    Optional<Trip> findByOrigin(Origin origin);

    Optional<Trip> findByFare(Fare fare);

}
