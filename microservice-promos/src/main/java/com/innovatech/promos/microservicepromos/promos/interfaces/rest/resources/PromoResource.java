package com.innovatech.promos.microservicepromos.promos.interfaces.rest.resources;

import java.util.Date;

public record PromoResource(Long id,
                            String Name,
                            String Description,
                            String ImageUrl,
                            Date ValidUntil) {
}
