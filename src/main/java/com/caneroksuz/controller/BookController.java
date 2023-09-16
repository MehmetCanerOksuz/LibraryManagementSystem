package com.caneroksuz.controller;

import com.caneroksuz.repository.ICrud;
import com.caneroksuz.repository.entity.Book;
import com.caneroksuz.repository.enums.EBookType;
import com.caneroksuz.service.BookService;

import java.util.List;
import java.util.Optional;

public class BookController implements ICrud<Book> {

    private BookService bookService;

    public BookController() {
        this.bookService = new BookService();
    }

    @Override
    public Book save(Book book) {
        return bookService.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookService.update(book);
    }

    @Override
    public Book deleteById(Long id) {
        return bookService.deleteById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookService.findById(id);
    }

    public List<Book> getBooksByType(EBookType type){
        return bookService.getBooksByType(type);
    }
    public List<Book> getBooksWithAuthorNameStartWith(String value){
        return bookService.getBooksWithAuthorNameStartWith(value);
    }
}
