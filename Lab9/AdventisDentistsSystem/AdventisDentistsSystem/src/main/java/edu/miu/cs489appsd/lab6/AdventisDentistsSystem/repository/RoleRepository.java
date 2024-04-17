package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.repository;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRoleName(String roleName);

}
