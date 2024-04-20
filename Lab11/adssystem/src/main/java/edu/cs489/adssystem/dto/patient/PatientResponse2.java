package edu.cs489.adssystem.dto.patient;

public record PatientResponse2(Integer patientId,
                               String firstName,

                               String lastName,

                               String contactPhoneNo,

                               String email,

                               String dob) {
}
