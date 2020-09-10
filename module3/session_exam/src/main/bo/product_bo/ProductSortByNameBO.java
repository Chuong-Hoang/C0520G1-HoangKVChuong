package main.bo.product_bo;


import main.model.product_model.Product;

import java.util.Comparator;

public class ProductSortByNameBO implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getProductName().compareTo(o2.getProductName());
    }
}
