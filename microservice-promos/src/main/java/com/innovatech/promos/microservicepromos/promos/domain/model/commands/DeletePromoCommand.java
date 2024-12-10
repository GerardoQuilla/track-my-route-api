package com.innovatech.promos.microservicepromos.promos.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record DeletePromoCommand(
        @NotBlank Long id
) {
}
