package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Product;
import vn.codegym.repository.ProductRepository;
import vn.codegym.repository.ProductRepositoryImplement;

import java.util.List;
@Service
public class ProductServiceImplement implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product el) {
        productRepository.save(el);
    }

    @Override
    public void update(String id, Product el) {
        productRepository.update(id, el);
    }

    @Override
    public void remove(String id) {
        productRepository.remove(id);
    }
}
