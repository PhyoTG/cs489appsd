package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.repository;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    public List<Patient> findPatientsByFirstnameStartingWith(String strNameStart);

    public List<Patient> findPatientsByPnoContainingOrFirstnameContainingOrLastnameContainingOrPhoneContainingOrPatientAddress_LocationContainingOrPatientAddress_ZipCodeContaining(
            String pno,String firstname, String lastname, String phone,String location, String zipCode
    );
}
