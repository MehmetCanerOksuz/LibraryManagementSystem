package com.caneroksuz.service;

import com.caneroksuz.repository.BookRepository;
import com.caneroksuz.repository.ICrud;
import com.caneroksuz.repository.entity.Book;
import com.caneroksuz.repository.enums.EBookType;

import java.util.List;
import java.util.Optional;

public class BookService implements ICrud<Book> {

    private BookRepository bookRepository;

    public BookService() {
        this.bookRepository = new BookRepository();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.update(book);
    }

    @Override
    public Book deleteById(Long id) {
        return bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getBooksByType(EBookType type){
        return bookRepository.getBooksByType(type);
    }
    public List<Book> getBooksWithAuthorNameStartWith(String value){
        return bookRepository.getBooksWithAuthorNameStartWith(value);
    }
}
