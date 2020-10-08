package vn.codegym.blog_manager.service;

import vn.codegym.blog_manager.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save(Category el);

    void delete(int id);

    long count();
}
