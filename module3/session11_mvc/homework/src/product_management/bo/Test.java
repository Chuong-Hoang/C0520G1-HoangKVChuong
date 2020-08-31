package product_management.bo;

import product_management.model.Product;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ProductBO productBO = new ProductBOImplement();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a name to find: ");
        String name = sc.nextLine();
        List<Product> productList = productBO.findByName(name);

        for(Product product : productList) {
            System.out.println(product.getName() + " --- " + product.getPrice());
        }

    }
}
