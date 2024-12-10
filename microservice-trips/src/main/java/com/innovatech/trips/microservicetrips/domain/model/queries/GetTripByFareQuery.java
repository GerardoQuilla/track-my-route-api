package com.innovatech.trips.microservicetrips.domain.model.queries;


import com.innovatech.trips.microservicetrips.domain.model.valueobjects.Fare;

public record GetTripByFareQuery(Fare fare) {

}
