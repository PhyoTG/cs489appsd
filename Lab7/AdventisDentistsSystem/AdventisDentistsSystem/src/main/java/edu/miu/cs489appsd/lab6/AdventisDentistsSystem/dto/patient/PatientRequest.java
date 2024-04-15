package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.patient;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.address.AddressRequest;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record PatientRequest(String patientNumber,
                             String firstname,
                             String lastname,
                             String phone,
                             LocalDate dob,
                             @Valid AddressRequest primaryAddress) {
}
