package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.repository;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DentistRepository   extends JpaRepository<Dentist,Integer> {

    public List<Dentist> findDentistsByFirstnameStartingWith(String strNameStart);
}
