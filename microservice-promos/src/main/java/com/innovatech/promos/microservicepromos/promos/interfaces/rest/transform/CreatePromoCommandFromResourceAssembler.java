package com.innovatech.promos.microservicepromos.promos.interfaces.rest.transform;


import com.innovatech.promos.microservicepromos.promos.domain.model.commands.CreatePromoCommand;
import com.innovatech.promos.microservicepromos.promos.interfaces.rest.resources.CreatePromoResource;

public class CreatePromoCommandFromResourceAssembler {
    public static CreatePromoCommand toCommandFromResource(CreatePromoResource resource){
        return new CreatePromoCommand(
                resource.name(),
                resource.description(),
                resource.imageUrl(),
                resource.validUntil()
        );
    }
}
