package com.innovatech.promos.microservicepromos.promos.application.internal;

import com.innovatech.promos.microservicepromos.promos.domain.model.entities.Promo;
import com.innovatech.promos.microservicepromos.promos.domain.model.queries.GetPromoByIdQuery;
import com.innovatech.promos.microservicepromos.promos.domain.model.queries.GetPromosQuery;
import com.innovatech.promos.microservicepromos.promos.domain.services.PromoQueryService;
import com.innovatech.promos.microservicepromos.promos.infrastructure.persistence.jpa.repositories.PromoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromoQueryServiceImpl implements PromoQueryService {

    private final PromoRepository promoRepository;

    public PromoQueryServiceImpl(PromoRepository promoRepository) {

        this.promoRepository = promoRepository;
    }

    public List<Promo> getAllPromos() {
        return promoRepository.findAll();
    }

    @Override
    public Optional<Promo> handle(GetPromoByIdQuery query) {
        return promoRepository.findById(query.id());
    }

    @Override
    public List<Promo> handle(GetPromosQuery query) {
        return promoRepository.findAll();
    }
}
