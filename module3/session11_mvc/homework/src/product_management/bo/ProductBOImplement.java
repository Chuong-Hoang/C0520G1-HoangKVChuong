package product_management.bo;

import product_management.dao.ProductDAO;
import product_management.dao.ProductDAOImplement;
import product_management.model.Product;

import java.util.List;

public class ProductBOImplement implements ProductBO {
    ProductDAO productDAO = new ProductDAOImplement();
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);

    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public List<Product> findByName(String nameString) {
        return productDAO.findByName(nameString);
    }

    @Override
    public void update(int id, Product product) {
        productDAO.update(id, product);
    }

    @Override
    public void remove(int id) {
        productDAO.remove(id);
    }

    @Override
    public int getNextId() {
        return productDAO.getNextId();
    }
}
