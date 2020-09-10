package main.bo.product_bo;

import main.dao.product_dao.ProductDAO;
import main.dao.product_dao.ProductDAOImplement;
import main.model.product_model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductBOImplement implements ProductBO {
    ProductDAO productDAO = new ProductDAOImplement();

    @Override
    public void create(Product el) throws SQLException {
        this.productDAO.create(el);
    }

    @Override
    public Product findById(String id) {
        return this.productDAO.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return this.productDAO.findAll();
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return this.productDAO.delete(id);
    }

    @Override
    public boolean update(String id, Product el) throws SQLException {
        return this.productDAO.update(id, el);
    }

    @Override
    public List<Product> findByName(String str) {
        return this.productDAO.findByName(str);
    }

}
