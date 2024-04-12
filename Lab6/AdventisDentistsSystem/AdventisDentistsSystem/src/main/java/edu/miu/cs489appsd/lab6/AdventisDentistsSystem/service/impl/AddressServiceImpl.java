package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.impl;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Address;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.repository.AddressRepository;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.AddressService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository AddressRepository;

    public AddressServiceImpl(AddressRepository AddressRepository) {
        this.AddressRepository = AddressRepository;
    }
    @Override
    public List<Address> getAllAddresses() {
        return AddressRepository.findAll();
    }

    @Override
    public Address addNewAddress(Address newAddress) {
        return AddressRepository.save(newAddress);
    }

    @Override
    public Address getAddressId(Integer AddressId) {
        return AddressRepository.findById(AddressId)
                .orElse(null);
    }

    @Override
    public Address updateAddress(Address editedAddress) {
        return AddressRepository.save(editedAddress);
    }

    @Override
    public void deleteAddressById(Integer AddressId) {
        AddressRepository.deleteById(AddressId);
    }
}
