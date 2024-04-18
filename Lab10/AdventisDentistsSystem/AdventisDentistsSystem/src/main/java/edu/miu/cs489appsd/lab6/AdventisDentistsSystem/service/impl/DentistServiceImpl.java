package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.impl;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Dentist;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.repository.DentistRepository;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {
    private DentistRepository DentistRepository;

    public DentistServiceImpl(DentistRepository DentistRepository) {
        this.DentistRepository = DentistRepository;
    }
    @Override
    public List<Dentist> getAllDentists() {
        return DentistRepository.findAll();
    }
    //Sort.by(Sort.Direction.ASC,"firstname")

    @Override
    public Dentist addNewDentist(Dentist newDentist) {
        return DentistRepository.save(newDentist);
    }

    @Override
    public Dentist getDentistId(Integer DentistId) {
        return DentistRepository.findById(DentistId)
                .orElse(null);
    }

    @Override
    public Dentist updateDentist(Dentist editedDentist) {
        return DentistRepository.save(editedDentist);
    }

    @Override
    public void deleteDentistById(Integer DentistId) {
        DentistRepository.deleteById(DentistId);
    }
}
