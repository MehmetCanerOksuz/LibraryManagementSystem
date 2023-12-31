package com.caneroksuz.service;

import com.caneroksuz.repository.AddressRepository;
import com.caneroksuz.repository.ICrud;
import com.caneroksuz.repository.entity.Address;

import java.util.List;
import java.util.Optional;

public class AddressService implements ICrud<Address> {

    private AddressRepository addressRepository;

    public AddressService() {
        this.addressRepository = new AddressRepository();
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        return addressRepository.update(address);
    }

    @Override
    public Address deleteById(Long id) {
        return addressRepository.deleteById(id);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }
}
