package vn.codegym.restful.service;

import vn.codegym.restful.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog obj);

   void remove(int id);
}
