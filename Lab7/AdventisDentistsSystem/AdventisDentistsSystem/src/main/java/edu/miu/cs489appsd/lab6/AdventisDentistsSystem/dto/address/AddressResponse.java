package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.address;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.patient.PatientResponse;

public record AddressResponse(Integer addressId,
                              String location,
                              String zipCode,
                              PatientResponse patientResponse
                              ) {
}
