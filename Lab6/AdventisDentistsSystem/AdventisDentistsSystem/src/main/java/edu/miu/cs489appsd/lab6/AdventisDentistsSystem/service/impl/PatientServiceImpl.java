package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.impl;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Patient;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.repository.PatientRepository;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.PatientService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository PatientRepository;

    public PatientServiceImpl(PatientRepository PatientRepository) {
        this.PatientRepository = PatientRepository;
    }
    @Override
    public List<Patient> getAllPatients() {
        return PatientRepository.findAll();
    }
    //Sort.by(Sort.Direction.ASC,"firstname")

    @Override
    public Patient addNewPatient(Patient newPatient) {
        return PatientRepository.save(newPatient);
    }

    @Override
    public Patient getPatientId(Integer PatientId) {
        return PatientRepository.findById(PatientId)
                .orElse(null);
    }

    @Override
    public Patient updatePatient(Patient editedPatient) {
        return PatientRepository.save(editedPatient);
    }

    @Override
    public void deletePatientById(Integer PatientId) {
        PatientRepository.deleteById(PatientId);
    }
}
