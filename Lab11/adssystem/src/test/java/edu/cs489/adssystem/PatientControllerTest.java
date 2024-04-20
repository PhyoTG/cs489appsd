package edu.cs489.adssystem;

import edu.cs489.adssystem.dto.patient.PatientResponse;
import edu.cs489.adssystem.exception.PatientNotFoundException;
import edu.cs489.adssystem.model.Address;
import edu.cs489.adssystem.model.Patient;
import edu.cs489.adssystem.repository.PatientRepository;
import edu.cs489.adssystem.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PatientControllerTest {
    @Mock
    PatientRepository patientRepository;

    @InjectMocks
    private PatientServiceImpl patientService;

    @BeforeEach
    void setUp(){

    }

    @Test
    public void testGetPatientById() throws PatientNotFoundException {
        Patient expectedPatient = new Patient(1, "Helen", "Smith", "00000000", "hsmith@example.com", "01-01-1990", new Address(1, "123 Street", "City", "State", "12345"));

        when(patientRepository.findById(1)).thenReturn(Optional.of(expectedPatient));

        PatientResponse actualResponse = patientService.getPatientById(1);

        assertEquals(expectedPatient.getPatientId(), actualResponse.patientId());
        assertEquals(expectedPatient.getFirstName(), actualResponse.firstName());
        assertEquals(expectedPatient.getLastName(), actualResponse.lastName());
        assertEquals(expectedPatient.getContactPhoneNo(), actualResponse.contactPhoneNo());
        assertEquals(expectedPatient.getEmail(), actualResponse.email());
        assertEquals(expectedPatient.getDob(), actualResponse.dob());
        assertEquals(expectedPatient.getAddress().getStreet(), actualResponse.address().getStreet());
        assertEquals(expectedPatient.getAddress().getCity(), actualResponse.address().getCity());
        assertEquals(expectedPatient.getAddress().getState(), actualResponse.address().getState());
        assertEquals(expectedPatient.getAddress().getZip(), actualResponse.address().getZip());
    }
}
