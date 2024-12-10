package com.innovatech.promos.microservicepromos.promos.domain.services;

import com.innovatech.promos.microservicepromos.promos.domain.model.entities.Promo;
import com.innovatech.promos.microservicepromos.promos.domain.model.queries.GetPromoByIdQuery;
import com.innovatech.promos.microservicepromos.promos.domain.model.queries.GetPromosQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PromoQueryService {
    Optional<Promo> handle(GetPromoByIdQuery query);
    List<Promo> handle(GetPromosQuery query);
}
