package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.impl;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Surgery;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.repository.SurgeryRepository;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.SurgeryService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    private SurgeryRepository SurgeryRepository;

    public SurgeryServiceImpl(SurgeryRepository SurgeryRepository) {
        this.SurgeryRepository = SurgeryRepository;
    }
    @Override
    public List<Surgery> getAllSurgeries() {
        return SurgeryRepository.findAll();
        //Sort.by(Sort.Direction.ASC,"date","time")
    }

    @Override
    public Surgery addNewSurgery(Surgery newSurgery) {
        return SurgeryRepository.save(newSurgery);
    }

    @Override
    public Surgery getSurgeryId(Integer SurgeryId) {
        return SurgeryRepository.findById(SurgeryId)
                .orElse(null);
    }

    @Override
    public Surgery updateSurgery(Surgery editedSurgery) {
        return SurgeryRepository.save(editedSurgery);
    }

    @Override
    public void deleteSurgeryById(Integer SurgeryId) {
        SurgeryRepository.deleteById(SurgeryId);
    }
}
