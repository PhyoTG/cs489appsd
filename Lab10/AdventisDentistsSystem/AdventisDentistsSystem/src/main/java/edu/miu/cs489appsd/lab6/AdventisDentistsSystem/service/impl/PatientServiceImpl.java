package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.impl;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.address.AddressResponse2;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.patient.PatientRequest;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.patient.PatientResponse2;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.exception.PatientNotFoundException;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Address;
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
    public PatientResponse2 addNewPatient(PatientRequest newPatient) {
        var newp = new Patient(null, newPatient.patientNumber(),newPatient.firstname(), newPatient.lastname(), newPatient.phone(), newPatient.dob());
        newp.setPatientAddress(new Address(null,newPatient.primaryAddress().location(),newPatient.primaryAddress().zipCode()));
        var savedPatient =  PatientRepository.save(newp);
        return new PatientResponse2(
                savedPatient.getPatientId(),
                savedPatient.getPno(),
                savedPatient.getFirstname(),
                savedPatient.getLastname(),
                savedPatient.getPhone(),
                new AddressResponse2(
                        savedPatient.getPatientAddress().getAddressId(),
                        savedPatient.getPatientAddress().getLocation(),
                        savedPatient.getPatientAddress().getZipCode()
                )
        );
    }

    @Override
    public PatientResponse2 getPatientId(Integer PatientId) throws PatientNotFoundException {
        Patient a = PatientRepository.findById(PatientId)
                .orElseThrow(() -> new PatientNotFoundException(String.format("Error: Patient with Id, %d, is not found",
                        PatientId)));
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
    public PatientResponse2 updatePatient(Integer patientID,PatientRequest editedPatient) throws PatientNotFoundException {
        var patient = PatientRepository.findById(patientID) .orElseThrow(() -> new PatientNotFoundException(String.format("Error: Patient with Id, %d, is not found",
                patientID)));
        if(patient != null ) {
            patient.setPno(editedPatient.patientNumber());
            patient.setFirstname(editedPatient.firstname());
            patient.setLastname(editedPatient.lastname());
            patient.setPhone(editedPatient.phone());
            patient.setDob(editedPatient.dob());
            if(patient.getPatientAddress()!=null) {
                var address = patient.getPatientAddress();
                address.setLocation(editedPatient.primaryAddress().location());
                address.setZipCode(editedPatient.primaryAddress().zipCode());
            } else {
                var newAddress = new Address();
                newAddress.setLocation(editedPatient.primaryAddress().location());
                newAddress.setZipCode(editedPatient.primaryAddress().zipCode());
                newAddress.setPatient(patient);
                patient.setPatientAddress(newAddress);
            }
            PatientRepository.save(patient);

            return new PatientResponse2(
                    patient.getPatientId(),
                    patient.getPno(),
                    patient.getFirstname(),
                    patient.getLastname(),
                    patient.getPhone(),
                    (patient.getPatientAddress()!= null)? new AddressResponse2(
                            patient.getPatientAddress().getAddressId(),
                            patient.getPatientAddress().getLocation(),
                            patient.getPatientAddress().getZipCode()):null);
        } else {
            return null;
        }
    }

    @Override
    public void deletePatientById(Integer PatientId) {
        PatientRepository.deleteById(PatientId);
    }

    @Override
    public List<PatientResponse2> searchPatient(String searchString) {
        return PatientRepository.findPatientsByPnoContainingOrFirstnameContainingOrLastnameContainingOrPhoneContainingOrPatientAddress_LocationContainingOrPatientAddress_ZipCodeContaining(
                searchString, searchString, searchString, searchString,searchString,searchString).
                stream()
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
}
