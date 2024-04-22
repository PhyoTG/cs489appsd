package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.patient;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.address.AddressResponse2;

public record PatientResponse2(Integer patientId,
                               String patientnumber,
                               String firstname,
                               String lastname,
                               String phone,
                               AddressResponse2 address) {
}
