package vn.codegym.blog_manager.service;

import vn.codegym.blog_manager.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog obj);

   void remove(int id);
}
