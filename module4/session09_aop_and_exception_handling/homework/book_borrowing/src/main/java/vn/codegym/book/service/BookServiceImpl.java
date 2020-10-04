package vn.codegym.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.book.model.Book;
import vn.codegym.book.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book el) {
        bookRepository.save(el);
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public long count() {
        return bookRepository.count();
    }
}
