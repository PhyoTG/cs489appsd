package edu.cs489.adssystem.dto.patient;

import edu.cs489.adssystem.model.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record PatientRequest (
        Integer patientId,

        @NotBlank(message = "First name is required and can't be null or blank")
        String firstName,
        @NotBlank(message = "Second name is required and can't be null or blank")
        String lastName,

        String contactPhoneNo,

        String email,
        String dob,
        @Valid
        Address address

        ) {
}
