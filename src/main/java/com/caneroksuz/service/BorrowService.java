package com.caneroksuz.service;

import com.caneroksuz.repository.BorrowRepository;
import com.caneroksuz.repository.ICrud;
import com.caneroksuz.repository.entity.Borrow;

import java.util.List;
import java.util.Optional;

public class BorrowService implements ICrud<Borrow> {

    private BorrowRepository borrowRepository;

    public BorrowService() {
        this.borrowRepository = new BorrowRepository();
    }

    @Override
    public Borrow save(Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    @Override
    public Borrow update(Borrow borrow) {
        return borrowRepository.update(borrow);
    }

    @Override
    public Borrow deleteById(Long id) {
        return borrowRepository.deleteById(id);
    }

    @Override
    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public Optional<Borrow> findById(Long id) {
        return borrowRepository.findById(id);
    }

    public void saveReturnDate(Borrow borrow) {
        borrow.setReturnDate(borrow.getBorrowDate().plusDays(borrow.getPeriod()));
    }
}
