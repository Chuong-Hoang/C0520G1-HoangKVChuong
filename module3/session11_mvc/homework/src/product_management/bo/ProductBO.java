package product_management.bo;

import product_management.model.Product;

import java.util.List;

public interface ProductBO {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    List<Product> findByName(String nameString);

    void update(int id, Product product);

    void remove(int id);

    int getNextId();
}
