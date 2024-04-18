package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.controller;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.dto.address.AddressResponse;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(value = "/adsweb/api/v1/address/list")
    public ResponseEntity<List<AddressResponse>> listAddress() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }
}
