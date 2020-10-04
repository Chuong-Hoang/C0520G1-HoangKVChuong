package vn.codegym.book.service;

import vn.codegym.book.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(int id);

    void save(Book el);

    void delete(int id);

    long count();
}
