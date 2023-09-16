package com.caneroksuz.controller;

import com.caneroksuz.repository.ICrud;
import com.caneroksuz.repository.entity.UserInformation;
import com.caneroksuz.service.UserInformationService;

import java.util.List;
import java.util.Optional;

public class UserInformationController implements ICrud<UserInformation> {

    private UserInformationService userInformationService;

    public UserInformationController() {
        this.userInformationService = new UserInformationService();
    }

    @Override
    public UserInformation save(UserInformation userInformation) {
        return userInformationService.save(userInformation);
    }

    @Override
    public UserInformation update(UserInformation userInformation) {
        return userInformationService.update(userInformation);
    }

    @Override
    public UserInformation deleteById(Long id) {
        return userInformationService.deleteById(id);
    }

    @Override
    public List<UserInformation> findAll() {
        return userInformationService.findAll();
    }

    @Override
    public Optional<UserInformation> findById(Long id) {
        return userInformationService.findById(id);
    }
}
