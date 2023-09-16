package com.caneroksuz.service;

import com.caneroksuz.repository.UsersRepository;
import com.caneroksuz.repository.ICrud;
import com.caneroksuz.repository.entity.Users;

import java.util.List;
import java.util.Optional;

public class UsersService implements ICrud<Users> {

    private UsersRepository usersRepository;

    public UsersService() {
        this.usersRepository = new UsersRepository();
    }

    @Override
    public Users save(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public Users update(Users user) {
        return usersRepository.update(user);
    }

    @Override
    public Users deleteById(Long id) {
        return usersRepository.deleteById(id);
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }
}
