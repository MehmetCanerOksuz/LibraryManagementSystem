package com.caneroksuz.controller;

import com.caneroksuz.repository.ICrud;
import com.caneroksuz.repository.entity.Author;
import com.caneroksuz.service.AuthorService;

import java.util.List;
import java.util.Optional;

public class AuthorController implements ICrud<Author> {

    private AuthorService authorService;

    public AuthorController() {
        this.authorService = new AuthorService();
    }

    @Override
    public Author save(Author author) {
        return authorService.save(author);
    }

    @Override
    public Author update(Author author) {
        return authorService.update(author);
    }

    @Override
    public Author deleteById(Long id) {
        return authorService.deleteById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorService.findById(id);
    }
}
