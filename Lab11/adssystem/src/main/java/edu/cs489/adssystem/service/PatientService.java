package edu.cs489.adssystem.service;


import edu.cs489.adssystem.dto.patient.PatientRequest;
import edu.cs489.adssystem.dto.patient.PatientResponse;
import edu.cs489.adssystem.exception.PatientNotFoundException;
import edu.cs489.adssystem.model.Patient;

import java.util.List;

public interface PatientService {
    PatientResponse savePatient(PatientRequest patientRequest);

    List<PatientResponse> getAllPatient();

    PatientResponse getPatientById(Integer patientId) throws PatientNotFoundException;

    PatientResponse updatePatient(Integer patientId, Patient editPatient);

    String deletePatientById(Integer patientId);

    void deletePatientByAddressId(Integer patientId);

    List<PatientResponse> searchPatient(String searchString);
}
