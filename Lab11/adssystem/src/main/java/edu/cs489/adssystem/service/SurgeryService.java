package edu.cs489.adssystem.service;

import edu.cs489.adssystem.model.Surgery;

import java.util.List;

public interface SurgeryService {
    Surgery saveSurgery(Surgery surgery);

    List<Surgery> getAllSurgeries();

    Surgery getSurgeryById(Integer surgeryId);

    Surgery updateSurgery(Surgery surgery);

    void deleteSurgery(Integer surgeryId);

}
