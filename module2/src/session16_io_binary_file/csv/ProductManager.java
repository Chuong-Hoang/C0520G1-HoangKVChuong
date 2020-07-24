package session16_io_binary_file.csv;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> productList = new ArrayList<>();

    public ProductManager() {
        //productList = new ArrayList<>();
    }

    public ProductManager(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void displayProductList() {
        System.out.println("__LIST OF PRODUCTS__");
        for (Product product : this.productList) {
            System.out.println(product);
        }
    }

    public void addNewProduct(Product product) {
        this.productList.add(product);
        System.out.println("Add product name " + product.getName() + " successfully.");
        for(Product p : productList) {
            System.out.println(p);
        }
        System.out.println("-----End product list-----");
    }

    public void updateProductName(String id, String name) {
        boolean isUpdated = false;
        for (int i = 0; i < productList.size(); i++) {
            if (id.compareTo(productList.get(i).getId()) == 0) {
                productList.get(i).setName(name);
                isUpdated = true;
                break;
            }
        }
        if (isUpdated)
            System.out.println("Update name " + name + " successfully");
        else
        System.out.println("Product id " + id + " does not exist in the list.");
    }

    public void updateProductPrice(String id, Double price) {
        boolean isUpdated = false;
        for (int i = 0; i < productList.size(); i++) {
            if (id.compareTo(productList.get(i).getId()) == 0) {
                productList.get(i).setPrice(price);
                isUpdated = true;
                break;
            }
        }
        if (isUpdated)
            System.out.println("Product id " + id + " updated price successfully");
        else
            System.out.println("Product id " + id + " does not exist in the list.");
    }

    public void updateProductDescription(String id, String desc) {
        boolean isUpdated = false;
        for (int i = 0; i < productList.size(); i++) {
            if (id.compareTo(productList.get(i).getId()) == 0) {
                productList.get(i).setDesc(desc);
                isUpdated = true;
                break;
            }
        }
        if (isUpdated)
            System.out.println("Update description successfully");
        else
            System.out.println("Product id " + id + " does not exist in the list.");
    }

    public void deleteProduct(String id) {
        boolean isFound = false;
        for (int i = 0; i < productList.size(); i++) {
            if (id.compareTo(productList.get(i).getId()) == 0) {
                productList.remove(i);
                isFound = true;
                break;
            }
        }
        if (isFound)
            System.out.println("Product id " + id + " deleted successfully");
        else
            System.out.println("Product id " + id + " does not exist in the list.");
    }
}
