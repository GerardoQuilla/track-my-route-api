package com.innovatech.promos.microservicepromos.promos.domain.services;

import com.innovatech.promos.microservicepromos.promos.domain.model.commands.CreatePromoCommand;
import com.innovatech.promos.microservicepromos.promos.domain.model.commands.DeletePromoCommand;
import com.innovatech.promos.microservicepromos.promos.domain.model.entities.Promo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PromoCommandService {
    Optional<Promo> handle(CreatePromoCommand command);
    Optional<Promo> handle(DeletePromoCommand command);
}
