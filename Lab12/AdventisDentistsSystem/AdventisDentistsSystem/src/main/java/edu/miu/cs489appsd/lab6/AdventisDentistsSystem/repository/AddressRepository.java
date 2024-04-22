package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.repository;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    public List<Address> findAddressesByLocationStartingWith(String location);
}
