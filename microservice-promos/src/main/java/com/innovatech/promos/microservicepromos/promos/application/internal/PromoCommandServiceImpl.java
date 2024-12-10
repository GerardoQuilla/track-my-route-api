package com.innovatech.promos.microservicepromos.promos.application.internal;

import com.innovatech.promos.microservicepromos.promos.domain.model.commands.CreatePromoCommand;
import com.innovatech.promos.microservicepromos.promos.domain.model.commands.DeletePromoCommand;
import com.innovatech.promos.microservicepromos.promos.domain.model.entities.Promo;
import com.innovatech.promos.microservicepromos.promos.domain.services.PromoCommandService;
import com.innovatech.promos.microservicepromos.promos.infrastructure.persistence.jpa.repositories.PromoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PromoCommandServiceImpl implements PromoCommandService {
    private final PromoRepository promoRepository;

    public PromoCommandServiceImpl(PromoRepository promoRepository) {
        this.promoRepository = promoRepository;
    }

    @Override
    public Optional<Promo> handle(CreatePromoCommand command) {
        var promo = new Promo(command);
        promoRepository.save(promo);
        return Optional.of(promo);
    }

    @Override
    public Optional<Promo> handle(DeletePromoCommand command) {
        var promo = promoRepository.findById(command.id());
        if (promo.isEmpty()) {
            throw new IllegalArgumentException("Promo with " + command.id() + " id not found");
        }
        promoRepository.delete(promo.get());
        return Optional.of(promo.get());
    }
}
