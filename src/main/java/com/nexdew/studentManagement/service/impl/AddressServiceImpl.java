package com.nexdew.studentManagement.service.impl;

import com.nexdew.studentManagement.entity.Address;
import com.nexdew.studentManagement.entity.Students;
import com.nexdew.studentManagement.repository.AddressRepository;
import com.nexdew.studentManagement.repository.StudentRepository;
import com.nexdew.studentManagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<Address> createAddress(List<Address> address) {
        return addressRepository.saveAll(address);
    }



}
