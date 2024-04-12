package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
    Patient addNewPatient(Patient newPatient);

    Patient getPatientId(Integer PatientId);

    Patient updatePatient(Patient editedPatient);

    void deletePatientById(Integer PatientId);
}
