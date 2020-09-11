package main.bo.product_bo;

import main.model.category_model.Category;
import main.model.product_model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductBO {
    public void create(Product el) throws SQLException;

    public Product findById(String id);

    public List<Product> findAll();

    public boolean delete(String id) throws SQLException;

    public boolean update(String id, Product el) throws SQLException;

    List<Product> findByName(String str);

    // list 2
    List<Category> findAllCateGory();
}
