package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.controller;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.patient.PatientResponse;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.patient.PatientResponse2;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Address;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Patient;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/patient")
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<PatientResponse2>> listPatient() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping(value = "/get/{patientId}")
    public ResponseEntity<PatientResponse2> getPatientById(@PathVariable Integer patientId){
        return ResponseEntity.ok(patientService.getPatientId(patientId));
    }
}
