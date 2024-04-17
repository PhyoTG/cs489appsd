package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.address;

import jakarta.validation.constraints.NotBlank;

public record AddressRequest(
        @NotBlank(message = "Location is required and cannot be null or empty string or blank spaces") String location,
        String zipCode
) { }
