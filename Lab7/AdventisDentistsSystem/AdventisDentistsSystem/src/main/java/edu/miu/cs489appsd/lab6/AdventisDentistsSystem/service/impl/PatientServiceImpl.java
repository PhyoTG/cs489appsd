package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.impl;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.address.AddressResponse;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.address.AddressResponse2;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.patient.PatientResponse;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.patient.PatientResponse2;
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
    public List<PatientResponse2> getAllPatients() {

        return PatientRepository.findAll(Sort.by(Sort.Direction.ASC,"lastname"))
                .stream()
                .map(a -> new PatientResponse2(
                        a.getPatientId(),
                        a.getPno(),
                        a.getFirstname(),
                        a.getLastname(),
                        a.getPhone(),
                        (a.getPatientAddress()!= null)? new AddressResponse2(
                                a.getPatientAddress().getAddressId(),
                                a.getPatientAddress().getLocation(),
                                a.getPatientAddress().getZipCode()): null
                )).toList();
    }
    //Sort.by(Sort.Direction.ASC,"firstname")

    @Override
    public Patient addNewPatient(Patient newPatient) {
        return PatientRepository.save(newPatient);
    }

    @Override
    public PatientResponse2 getPatientId(Integer PatientId) {
        Patient a = PatientRepository.findById(PatientId)
                .orElse(null);
        return a!=null? new PatientResponse2(
                a.getPatientId(),
                a.getPno(),
                a.getFirstname(),
                a.getLastname(),
                a.getPhone(),
                (a.getPatientAddress()!= null)? new AddressResponse2(
                        a.getPatientAddress().getAddressId(),
                        a.getPatientAddress().getLocation(),
                        a.getPatientAddress().getZipCode()): null
        ):null;
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
