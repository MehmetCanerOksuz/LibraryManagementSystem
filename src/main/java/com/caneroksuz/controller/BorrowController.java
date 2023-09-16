package com.caneroksuz.controller;

import com.caneroksuz.repository.ICrud;
import com.caneroksuz.repository.entity.Borrow;
import com.caneroksuz.service.BorrowService;

import java.util.List;
import java.util.Optional;

public class BorrowController implements ICrud<Borrow> {

    private BorrowService borrowService;

    public BorrowController() {
        this.borrowService = new BorrowService();
    }

    @Override
    public Borrow save(Borrow borrow) {
        borrowService.saveReturnDate(borrow);
        return borrowService.save(borrow);
    }

    @Override
    public Borrow update(Borrow borrow) {
        return borrowService.update(borrow);
    }

    @Override
    public Borrow deleteById(Long id) {
        return borrowService.deleteById(id);
    }

    @Override
    public List<Borrow> findAll() {
        return borrowService.findAll();
    }

    @Override
    public Optional<Borrow> findById(Long id) {
        return borrowService.findById(id);
    }
}
