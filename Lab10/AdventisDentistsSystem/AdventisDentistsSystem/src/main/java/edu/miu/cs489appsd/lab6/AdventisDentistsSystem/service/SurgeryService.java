package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Surgery;

import java.util.List;

public interface SurgeryService {
    List<Surgery> getAllSurgeries();
    Surgery addNewSurgery(Surgery newSurgery);

    Surgery getSurgeryId(Integer SurgeryId);

    Surgery updateSurgery(Surgery editedSurgery);

    void deleteSurgeryById(Integer SurgeryId);
}
