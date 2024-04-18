package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.patient.PatientRequest;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.patient.PatientResponse2;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.exception.PatientNotFoundException;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Patient;

import java.util.List;

public interface PatientService {
    List<PatientResponse2> getAllPatients();

    Patient addNewPatient(Patient patient);
    PatientResponse2 addNewPatient(PatientRequest newPatient);

    PatientResponse2 getPatientId(Integer PatientId) throws PatientNotFoundException;

    Patient updatePatient(Patient editedPatient);

    PatientResponse2 updatePatient(Integer patientID,PatientRequest editedPatient) throws PatientNotFoundException;

    void deletePatientById(Integer PatientId);

    List<PatientResponse2> searchPatient(String searchString);
}
