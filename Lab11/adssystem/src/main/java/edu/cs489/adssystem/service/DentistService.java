package edu.cs489.adssystem.service;


import edu.cs489.adssystem.model.Dentist;

import java.util.List;

public interface DentistService {
    Dentist saveDentist(Dentist dentist);

    List<Dentist> getAllDentists();

    Dentist getDentistById(Integer dentistId);

    Dentist updateDentist(Dentist dentist);

    void deleteDentistById(Integer dentistId);
}
