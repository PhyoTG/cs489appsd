package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.user;

import java.util.List;

public record UserRequest(
        String username,
        String password,
        String firstName,
        String lastName,
        String email,
        List<Integer> roleIds
) {
}
