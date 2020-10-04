package vn.codegym.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.book.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
