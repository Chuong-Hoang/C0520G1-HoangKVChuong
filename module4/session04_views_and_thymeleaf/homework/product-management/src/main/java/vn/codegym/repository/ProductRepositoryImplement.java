package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepositoryImplement implements ProductRepository {
    // Simulate an available database
    private static Map<String, Product> eListMap;
    static {
        eListMap = new HashMap<>();
        eListMap.put("1", new Product("1", "Name 1", "1000", "30", "black", "Made in Vietnam", "Phone"));
        eListMap.put("2", new Product("2", "Name 2", "1500", "15", "green", "Made in China", "Television"));
        eListMap.put("3", new Product("3", "Name 3", "50000", "40", "blue", "Made in Australia", "Car"));
        eListMap.put("4", new Product("4", "Product 4", "30.99", "25", "yellow", "Made in Japan", "Toy"));
        eListMap.put("5", new Product("5", "Product 5", "5.99", "50", "purple", "Made in USA", "Stuff"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(eListMap.values());
    }

    @Override
    public Product findById(String id) {
        return eListMap.get(id);
    }

    @Override
    public void save(Product el) {
        eListMap.put(el.getProductId(), el);
    }

    @Override
    public void update(String id, Product el) {
        eListMap.put(id, el);
    }

    @Override
    public void remove(String id) {
        eListMap.remove(id);
    }
}
