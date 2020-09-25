package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Blog;
import vn.codegym.repository.BlogRepository;

import java.util.List;
@Service
public class BlogServiceImplement implements BlogService {
    @Autowired
    BlogRepository objectRepository;

    @Override
    public List<Blog> findAll() {
        return objectRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return objectRepository.findById(id);
    }

    @Override
    public void save(Blog obj) {
        objectRepository.save(obj);
    }

    @Override
    public void update(Blog obj) {
        objectRepository.update(obj);
    }

    @Override
    public void remove(int id) {
        objectRepository.remove(id);
    }
}
