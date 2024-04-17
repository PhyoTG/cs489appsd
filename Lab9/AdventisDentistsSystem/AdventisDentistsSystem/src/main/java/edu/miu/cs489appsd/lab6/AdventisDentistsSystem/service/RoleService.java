package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Role;

public interface RoleService {
    Role addNewRole(Role role);

    Role getRoleById(Integer id);
}
