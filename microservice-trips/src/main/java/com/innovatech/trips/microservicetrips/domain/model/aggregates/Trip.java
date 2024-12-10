package com.innovatech.trips.microservicetrips.domain.model.aggregates;

import com.innovatech.trips.microservicetrips.domain.model.commands.CreateTripCommand;
import com.innovatech.trips.microservicetrips.domain.model.valueobjects.Destination;
import com.innovatech.trips.microservicetrips.domain.model.valueobjects.Fare;
import com.innovatech.trips.microservicetrips.domain.model.valueobjects.Origin;
import com.innovatech.trips.microservicetrips.domain.model.valueobjects.Time;
import com.innovatech.trips.microservicetrips.shared.model.aggregate.AuditableAbstractAggregateRoot;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Trip extends AuditableAbstractAggregateRoot<Trip> {

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "origin_value"))
    Origin origin;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "destination_value"))
    Destination destination;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "time_value"))
    Time time;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "fare_value"))
    Fare fare;

    public Trip(CreateTripCommand command) {
        this.origin = new Origin(command.origin());
        this.destination = new Destination(command.destination());
        this.time = new Time(command.time());
        this.fare = new Fare(command.fare());
    }

    public String getOrigin(){
        return origin.value();
    }

    public String getTime(){
        return time.value();
    }

    public String getFare(){
        return fare.value();
    }

    public String getDestination(){
        return destination.value();
    }

}
