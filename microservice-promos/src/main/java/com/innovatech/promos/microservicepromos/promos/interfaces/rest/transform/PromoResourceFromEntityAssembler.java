package com.innovatech.promos.microservicepromos.promos.interfaces.rest.transform;


import com.innovatech.promos.microservicepromos.promos.domain.model.entities.Promo;
import com.innovatech.promos.microservicepromos.promos.interfaces.rest.resources.PromoResource;

public class PromoResourceFromEntityAssembler {
    public static PromoResource transformResourceFromEntity(Promo entity){
        return new PromoResource(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getImageUrl(),
                entity.getValidUntil());
    }
}
