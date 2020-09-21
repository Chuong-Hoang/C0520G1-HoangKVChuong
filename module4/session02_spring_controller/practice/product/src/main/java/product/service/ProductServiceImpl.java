package product.service;

import product.model.Product;
import product.repository.ProductRepository;
import product.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository = new ProductRepositoryImpl();
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
