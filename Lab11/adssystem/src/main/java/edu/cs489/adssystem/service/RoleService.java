package edu.cs489.adssystem.service;


import edu.cs489.adssystem.model.Role;

import java.util.List;

public interface RoleService {
    Role saveRole(Role role);

    List<Role> getAllRoles();

    Role getRoleById(Integer roleId);

    Role updateRole(Role role);

    void deleteRoleById(Integer roleId);
}
