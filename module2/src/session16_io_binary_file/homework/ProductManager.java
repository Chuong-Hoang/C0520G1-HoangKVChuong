package session16_io_binary_file.homework;

import java.util.*;
import java.io.*;

public class ProductManager {
    public static List<Product> productList = new ArrayList<>();
    public static final String FILE_NAME = "src/session16_io_binary_file/homework/products.txt";
    public static final  File FILE = new File(FILE_NAME);
    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("<-- MAIN MENU -->");
        System.out.println("1. Add new product");
        System.out.println("2. Display all products");
        System.out.println("3. Find a product");
        System.out.println("4. Edit a product");
        System.out.println("5. Delete a product");
        System.out.println("6. Exit");
        System.out.print("Select an option: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                addProduct();
                writeProductList(FILE);
                break;
            case 2:
                readProductList(FILE);
                break;
            case 3:
                findProduct();
                readProductList(FILE);
                break;
            case 4:
                editProduct();
                writeProductList(FILE);
                readProductList(FILE);
                break;
            case 5:
                deleteProduct();
                writeProductList(FILE);
                readProductList(FILE);
                break;
            case 6:
            default:
                System.exit(0);
        }
        showMainMenu();

    }

    public static void addProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input id: ");
        String id = sc.nextLine();

        System.out.print("Input name: ");
        String name = sc.nextLine();

        System.out.print("Input brand: ");
        String brand = sc.nextLine();

        System.out.print("Input price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Input description: ");
        String desc = sc.nextLine();

        productList.add(new Product(id, name, brand, price, desc));

    }

    public static void findProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input product id: ");
        String id = sc.nextLine();
        int index = -1;

        for (int i = 0; i < productList.size(); i++) {
            if (id.compareTo(productList.get(i).getId()) == 0) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("Found result:");
            System.out.println(productList.get(index));
        } else {
            System.out.println("Product id " + id + " not found!");
        }
    }

    public static void editProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input product id: ");
        String id = sc.nextLine();
        int index = -1;

        for (int i = 0; i < productList.size(); i++) {
            if (id.compareTo(productList.get(i).getId()) == 0) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            Product product = productList.get(index);
            System.out.print("Input new Id: ");
            String newId = sc.nextLine();

            System.out.print("Input new name: ");
            String newName = sc.nextLine();

            System.out.print("Input new brand: ");
            String newBrand = sc.nextLine();

            System.out.print("Input new price: ");
            double newPrice = sc.nextDouble();
            sc.nextLine();

            System.out.print("Input new description: ");
            String newDesc = sc.nextLine();

            product.setId(newId);
            product.setName(newName);
            product.setBrand(newBrand);
            product.setPrice(newPrice);
            product.setDesc(newDesc);
        } else {
            System.out.println("Product id " + id + " not found!");
        }
    }

    public static void deleteProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input product id: ");
        String id = sc.nextLine();
        int index = -1;

        for (int i = 0; i < productList.size(); i++) {
            if (id.compareTo(productList.get(i).getId()) == 0) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            productList.remove(index);
        } else {
            System.out.println("Product id " + id + " not found!");
        }
    }

    public static void writeProductList(File file) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file.getAbsoluteFile());
            oos = new ObjectOutputStream(fos);

            oos.writeObject(productList);

            fos.flush();
            fos.close();
            oos.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public static void readProductList(File file) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            if (!file.exists()) {
                throw new FileNotFoundException("File does not exist.");
            } else {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);

                productList = (List<Product>) ois.readObject();

                for (Product product : productList) {
                    System.out.println(product);
                }
                System.out.println("-------------------------------");

                fis.close();
                ois.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e);
        }
    }
}
