package com.caneroksuz.controller;

import com.caneroksuz.repository.ICrud;
import com.caneroksuz.repository.entity.Address;
import com.caneroksuz.service.AddressService;

import java.util.List;
import java.util.Optional;

public class AddressController implements ICrud<Address> {

    private AddressService addressService;

    public AddressController() {
        this.addressService = new AddressService();
    }

    @Override
    public Address save(Address address) {
        return addressService.save(address);
    }

    @Override
    public Address update(Address address) {
        return addressService.update(address);
    }

    @Override
    public Address deleteById(Long id) {
        return addressService.deleteById(id);
    }

    @Override
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressService.findById(id);
    }
}
