package edu.cs489.adssystem.service;

import edu.cs489.adssystem.dto.address.AddressResponse;
import edu.cs489.adssystem.exception.AddressNotFoundException;
import edu.cs489.adssystem.model.Address;

import java.util.List;

public interface AddressService {
    Address saveAddress(Address address);

    List<AddressResponse> getAllAddress();

    Address getAddressById(Integer addressId) throws AddressNotFoundException;

    Address updateAddress(Address address);

    void deleteAddressById(Integer addressId);
}
