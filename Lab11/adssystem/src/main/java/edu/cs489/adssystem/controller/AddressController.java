package edu.cs489.adssystem.controller;

import edu.cs489.adssystem.dto.address.AddressResponse;
import edu.cs489.adssystem.exception.AddressNotFoundException;
import edu.cs489.adssystem.model.Address;
import edu.cs489.adssystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    public ResponseEntity<List<AddressResponse>> getAllAddress(){
        return ResponseEntity.ok(addressService.getAllAddress());
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Address> getAddressById(@PathVariable Integer addressId) throws AddressNotFoundException {
        return ResponseEntity.ok(addressService.getAddressById(addressId));
    }
}
