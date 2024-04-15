package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Dentist;

import java.util.List;

public interface DentistService {
    List<Dentist> getAllDentists();
    Dentist addNewDentist(Dentist newDentist);

    Dentist getDentistId(Integer DentistId);

    Dentist updateDentist(Dentist editedDentist);

    void deleteDentistById(Integer DentistId);
}
