package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.patient;

public record PatientResponse(Integer patientId,
                              String patientnumber,
                              String firstname,
                              String lastname,
                              String phone) {
}
