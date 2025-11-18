package com.nexdew.studentManagement.controller;

import com.nexdew.studentManagement.entity.Address;
import com.nexdew.studentManagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<List<Address>> createAddress(@RequestBody List<Address> address) {
        List<Address> createdAddress = addressService.createAddress(address);
        return ResponseEntity.ok(createdAddress);
    }
}
