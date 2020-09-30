package vn.codegym.product.service;

import vn.codegym.product.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save(Category el);

    void delete(int id);

    long count();
}
