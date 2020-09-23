package vn.codegym.service;

import vn.codegym.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(String id);

    void save(Product el);

    void update(String id, Product el);

    void remove(String id);
}
