package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.user;

public record UserAuthResponse(String jwtToken,
                               String firstName,
                               String lastName) {
}
