package session16_io_binary_file.csv;

import java.util.Scanner;

public class MainController {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        ProductManager productManager = new ProductManager();

        System.out.println("........MAIN MENU.........");
        System.out.println("1.Add new product");
        System.out.println("2.Display all products");
        System.out.println("3.Update product name");
        System.out.println("4.Update product description");
        System.out.println("5.Update product price");
        System.out.println("6.Delete a product");
        System.out.println("7.Exit");
        System.out.println("..........................");
        System.out.print("Select an option: ");
        int option = Integer.parseInt(sc.nextLine());

        switch (option) {
            case 1: // add new product
                System.out.println("<--Add new product-->");
                System.out.print("Input product id: ");
                String id = sc.nextLine();
                System.out.print("Input product name: ");
                String name = sc.nextLine();
                System.out.print("Input product brand: ");
                String brand = sc.nextLine();
                System.out.print("Input product description: ");
                String desc = sc.nextLine();
                System.out.print("Input product price: ");
                double price = Double.parseDouble(sc.nextLine());
                Product newProduct = new Product(id, name, brand, desc, price);

                productManager.setProductList(ProductUtils.readProductFile());
                productManager.addNewProduct(newProduct);
                ProductUtils.writeProductFile(productManager.getProductList());
                break;
            case 2: //display all products
                productManager.setProductList(ProductUtils.readProductFile());
                productManager.displayProductList();
                break;
            case 3: //update product name
                System.out.print("Input product id to rename: ");
                id = sc.nextLine();
                System.out.print("Input new name: ");
                name = sc.nextLine();

                productManager.setProductList(ProductUtils.readProductFile());
                productManager.updateProductName(id, name);
                ProductUtils.writeProductFile(productManager.getProductList());
                break;
            case 4: //update product description
                System.out.print("Input product id to update description: ");
                id = sc.nextLine();
                System.out.print("Input new product description: ");
                desc = sc.nextLine();

                productManager.setProductList(ProductUtils.readProductFile());
                productManager.updateProductDescription(id, desc);
                ProductUtils.writeProductFile(productManager.getProductList());
                break;
            case 5: //update product price
                System.out.print("Input product id to update price: ");
                id = sc.nextLine();
                System.out.print("Input new product price: ");
                price = Double.parseDouble(sc.nextLine());

                productManager.setProductList(ProductUtils.readProductFile());
                productManager.updateProductPrice(id, price);
                ProductUtils.writeProductFile(productManager.getProductList());
                break;
            case 6: //delete a product
                System.out.print("Input product id to be deleted: ");
                id = sc.nextLine();

                productManager.setProductList(ProductUtils.readProductFile());
                productManager.deleteProduct(id);
                ProductUtils.writeProductFile(productManager.getProductList());
                break;
            case 7: //Exit
            default: //Exit
                System.exit(0);
        }
        System.out.println();
        showMainMenu();
    }
}
