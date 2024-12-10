package com.innovatech.microserviceprofile.profile.interfaces.rest.resources;

public record CreateProfileResource(String name, String email, String phone, String address, String imageUrl, String password, String role) {
}
