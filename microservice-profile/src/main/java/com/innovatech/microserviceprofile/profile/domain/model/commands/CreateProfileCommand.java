package com.innovatech.microserviceprofile.profile.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record CreateProfileCommand( @NotBlank String name,
                                    @NotBlank String email,
                                    @NotBlank String phone,
                                    @NotBlank String address,
                                    @NotBlank String imageUrl,
                                    @NotBlank String password,
                                    @NotBlank String role) {

}
