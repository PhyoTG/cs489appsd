package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.controller;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.patient.PatientRequest;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.patient.PatientResponse2;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.exception.PatientNotFoundException;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<PatientResponse2> getPatientById(@PathVariable Integer patientId) throws PatientNotFoundException {
        return ResponseEntity.ok(patientService.getPatientId(patientId));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<PatientResponse2> registerNewPublisher(@RequestBody @Valid PatientRequest patientRequest) {
        return new ResponseEntity<>(patientService.addNewPatient(patientRequest), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{patientId}")
    public ResponseEntity<PatientResponse2> updatePatient(@PathVariable Integer patientId,
                                                     @RequestBody PatientRequest editedPublisher) throws PatientNotFoundException {
        return new ResponseEntity<PatientResponse2>(patientService.updatePatient(patientId, editedPublisher),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{patientId}")
    public ResponseEntity<Void> deletePatientById(@PathVariable Integer patientId) {
        patientService.deletePatientById(patientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/search/{searchString}")
    public ResponseEntity<List<PatientResponse2>> searchPatient(@PathVariable String searchString) {
        return ResponseEntity.ok(patientService.searchPatient(searchString));
    }
}
