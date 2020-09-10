package main.dao.product_dao;


import main.model.product_model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {

    public void create(Product el) throws SQLException;

    //public Customer findById(int id);
    public Product findById(String id);

    public List<Product> findAll();

    public boolean delete(String id) throws SQLException;
    //public boolean delete(int id) throws SQLException;

    //public boolean update(Service el) throws SQLException;
    public boolean update(String id, Product el) throws SQLException;

    List<Product> findByName(String str);

}
