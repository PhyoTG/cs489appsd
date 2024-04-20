package edu.cs489.adssystem;

import edu.cs489.adssystem.controller.PatientController;
import edu.cs489.adssystem.dto.patient.PatientResponse;
import edu.cs489.adssystem.model.Address;
import edu.cs489.adssystem.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PatientServiceImplTest {

    @Mock
    private PatientServiceImpl patientService;

    @InjectMocks
    private PatientController patientController;

    @BeforeEach
    void setUp(){

    }

    @Test
    public void testGetAllPatient(){
        List<PatientResponse> expectedPatients = Arrays.asList(
                new PatientResponse(1, "Helen", "Smith", "00000000", "h.smith@example.com", "01-01-1990", new Address(1, "123 Street", "City", "State", "12345")),
                new PatientResponse(2, "Taylor", "Swift", "9876543210", "t.swift@example.com", "02-02-1990", new Address(2, "456 Avenue", "Town", "State", "54321"))
        );

        when(patientService.getAllPatient()).thenReturn(expectedPatients);

        ResponseEntity<List<PatientResponse>> responseEntity = patientController.getAllPatient();
        List<PatientResponse> actualPatients = responseEntity.getBody();

        assertEquals(expectedPatients.size(), actualPatients.size());
        assertEquals(expectedPatients.get(0).firstName(), actualPatients.get(0).firstName());
        assertEquals(expectedPatients.get(0).lastName(), actualPatients.get(0).lastName()); // Corrected assertion
        assertEquals(expectedPatients.get(0).contactPhoneNo(), actualPatients.get(0).contactPhoneNo());
        assertEquals(expectedPatients.get(0).email(), actualPatients.get(0).email());
        assertEquals(expectedPatients.get(0).dob(), actualPatients.get(0).dob());
        assertEquals(expectedPatients.get(0).address().getStreet(), actualPatients.get(0).address().getStreet());
        assertEquals(expectedPatients.get(0).address().getCity(), actualPatients.get(0).address().getCity());
        assertEquals(expectedPatients.get(0).address().getState(), actualPatients.get(0).address().getState());
        assertEquals(expectedPatients.get(0).address().getZip(), actualPatients.get(0).address().getZip());
    }

}
