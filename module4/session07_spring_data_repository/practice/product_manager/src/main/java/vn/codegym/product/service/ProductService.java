package vn.codegym.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    void save(Product el);

    void delete(int id);

    long count();

    // Find by name
    Page<Product> findByName(String input, Pageable pageable);

    // Paging
    Page<Product> findAll(Pageable pageable);

    // Find by category
    Page<Product> findByCategory(Integer categoryId, Pageable pageable);
}
