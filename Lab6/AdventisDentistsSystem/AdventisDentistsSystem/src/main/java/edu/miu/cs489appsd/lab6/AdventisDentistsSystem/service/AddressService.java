package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();
    Address addNewAddress(Address newAddress);

    Address getAddressId(Integer AddressId);

    Address updateAddress(Address editedAddress);

    void deleteAddressById(Integer AddressId);
}
