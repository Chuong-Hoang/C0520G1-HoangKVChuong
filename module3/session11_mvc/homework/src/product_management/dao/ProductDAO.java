package product_management.dao;

import product_management.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    List<Product> findByName(String nameString);

    void update(int id, Product product);

    void remove(int id);

    int getNextId();

}
