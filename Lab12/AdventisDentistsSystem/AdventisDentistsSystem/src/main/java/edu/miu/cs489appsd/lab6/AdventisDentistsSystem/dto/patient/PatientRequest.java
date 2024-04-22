package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.patient;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.address.AddressRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record PatientRequest(
        @NotBlank(message = "PatientNumber is required and cannot be null or empty string or blank spaces") String patientNumber,
        @NotBlank(message = "First name is required and cannot be null or empty string or blank spaces") String firstname,
                             String lastname,
        @NotBlank(message = "Phone is required and cannot be null or empty string or blank spaces") String phone,
                             LocalDate dob,
                             @Valid AddressRequest primaryAddress) {
}
