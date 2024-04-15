package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.patient.PatientResponse2;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Patient;

import java.util.List;

public interface PatientService {
    List<PatientResponse2> getAllPatients();
    Patient addNewPatient(Patient newPatient);

    PatientResponse2 getPatientId(Integer PatientId);

    Patient updatePatient(Patient editedPatient);

    void deletePatientById(Integer PatientId);
}
