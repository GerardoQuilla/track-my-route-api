package com.innovatech.promos.microservicepromos.promos.infrastructure.persistence.jpa.repositories;

import com.innovatech.promos.microservicepromos.promos.domain.model.entities.Promo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoRepository extends JpaRepository<Promo, Long> {
}
