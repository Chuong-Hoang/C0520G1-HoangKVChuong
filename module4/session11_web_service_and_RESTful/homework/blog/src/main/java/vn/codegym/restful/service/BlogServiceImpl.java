package vn.codegym.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.restful.model.Blog;
import vn.codegym.restful.repository.BlogRepository;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog obj) {
        blogRepository.save(obj);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }
}
