package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.user;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.role.RoleResponse;

import java.util.List;

public record UserResponse(Integer userId,
                           String username,
                           String password,
                           String firstName,
                           String lastName,
                           String email,
                           boolean accountNonExpired,
                           boolean accountNonLocked,
                           boolean credentialsNonExpired,
                           boolean enabled,
                           List<RoleResponse> roleResponses) {
}
