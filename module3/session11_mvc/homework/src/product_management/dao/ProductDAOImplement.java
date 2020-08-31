package product_management.dao;

import product_management.model.Product;

import java.util.*;

public class ProductDAOImplement implements ProductDAO {
    private static Map<Integer, Product> elements;

    static {
        elements = new HashMap<>();

        elements.put(1, new Product(1, "Pa_1", "1000", "...", "A"));
        elements.put(2, new Product(2, "Pan_2", "1200", "...", "B"));
        elements.put(3, new Product(3, "Pbn_3", "1400", "...", "C"));
        elements.put(4, new Product(4, "Prn_4", "1600", "...", "D"));
        elements.put(5, new Product(5, "Pacb_5", "1800", "...", "E"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(elements.values());
    }

    @Override
    public void save(Product product) {
        elements.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return elements.get(id);
    }

    @Override
    public List<Product> findByName(String nameString) {
        List<Product> productList = new ArrayList<>(elements.values());
        List<Product> productFound = new ArrayList<>();
        for(Product product : productList){
            if (product.getName().toLowerCase().contains(nameString.toLowerCase())) {
                productFound.add(product);
            }
        }

        return productFound;
    }

    @Override
    public void update(int id, Product product) {
        elements.put(id, product);
    }

    @Override
    public void remove(int id) {
        elements.remove(id);
    }

    @Override
    public int getNextId() {
        return elements.size() + 1;
    }
}
