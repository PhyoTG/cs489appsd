package edu.cs489.adssystem.dto.patient;

import edu.cs489.adssystem.model.Address;

public record PatientResponse(Integer patientId,
                              String firstName,

                              String lastName,

                              String contactPhoneNo,

                              String email,

                              String dob,
                              Address address) {

}
