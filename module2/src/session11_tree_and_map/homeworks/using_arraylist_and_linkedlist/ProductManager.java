package session11_tree_and_map.homeworks.using_arraylist_and_linkedlist;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product("Erisson 1", 111, 3400));
        productList.add(new Product("Erisson 3", 122, 6400));
        productList.add(new Product("Erisson 5", 211, 3100));
        productList.add(new Product("Erisson 7", 121, 7400));

        mainMenu(productList);

    }
    public static void mainMenu(ArrayList<Product> list){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("MAIN MENU");
        System.out.println("1. Add new product");
        System.out.println("2. Edit a product");
        System.out.println("3. Remove a product");
        System.out.println("4. Find a product");
        System.out.println("5. Sort products by ascending price");
        System.out.println("6. Sort products by descending price");
        System.out.println("7. Display all products");
        System.out.println("8. EXIT");
        System.out.print("Choose option to be executed: ");

        int option = myScanner.nextInt();
        switch (option) {
            case 1:
                addProduct(list);
                break;
            case 2:
                editProduct(list);
                break;
            case 3:
                removeProduct(list);
                break;
            case 4:
                findProduct(list);
                break;
            case 5:
                sortAscendingPrice(list);
                break;
            case 6:
                sortDescendingPrice(list);
                break;
            case 7:
                displayProduct(list);
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("No action executed!");
        }
        mainMenu(list);
    }

    public static void addProduct(ArrayList<Product> list) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input new product name: ");
        String name = myScanner.nextLine();

        System.out.print("Input new product Id: ");
        int id = myScanner.nextInt();

        System.out.print("Input new product Price: ");
        int price = myScanner.nextInt();
        Product p = new Product(name, id, price);
        list.add(p);
        displayProduct(list);
    }

    public static void editProduct(ArrayList<Product> list) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input Id product to be edited: ");
        int id = myScanner.nextInt();
        Product p = null;
        for (Product product : list) {
            if(id == product.getId()){
                p = product;
                break;
            }
        }

         if (p == null) {
             System.out.println("Id product " + id + " not found!");
         } else {
             System.out.print("Enter new Name product: ");
             String newName = myScanner.nextLine();
             p.setName(newName);

             System.out.print("Enter new ID product: ");
             int newId = myScanner.nextInt();
             p.setId(newId);

             System.out.print("Enter new Price product: ");
             int newPrice = myScanner.nextInt();
             p.setPrice(newPrice);

             System.out.println("New Edition: " + p.toString());
             displayProduct(list);
         }
    }

    public static void removeProduct(ArrayList<Product> list) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input Id product to be removed: ");
        int id = myScanner.nextInt();
        Product p = null;
        for (Product product : list) {
            if(id == product.getId()){
                p = product;
                break;
            }
        }

        if (p == null) {
            System.out.println("Id product " + id + " not found!");
        } else {
            System.out.print("Remove product with Id " + id + "? Yes(1) or No(0)?");
            int choose = myScanner.nextInt();
            if(choose == 1) {
                list.remove(p);
            } else {
                System.out.println("No product removed!");
            }
            displayProduct(list);
        }
    }

    public static void findProduct(ArrayList<Product> list) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input Id product: ");
        int id = myScanner.nextInt();
        Product p = null;
        for (Product product : list) {
            if(id == product.getId()){
                p = product;
                break;
            }
        }

        if (p == null) {
            System.out.println("Id product " + id + " not found!");
        } else {
            System.out.println("Result: " + p);
        }
    }

    public static void sortAscendingPrice(ArrayList<Product> list) {
        SortAscendingPrice ascendingPrice = new SortAscendingPrice();
        Collections.sort(list, ascendingPrice);
        displayProduct(list);
    }

    public static void sortDescendingPrice(ArrayList<Product> list) {
        SortDescendingPrice descendingPrice = new SortDescendingPrice();
        Collections.sort(list, descendingPrice);
        displayProduct(list);
    }

    public static void displayProduct(ArrayList<Product> list) {
        if (!list.isEmpty()) {
            System.out.println("-- LIST OF PRODUCTS --");
            int i = 1;
            for (Product p : list) {
                System.out.println(i + ". " + p);
                i++;
            }
            System.out.println("------------------------------");
        } else {
            System.out.println("The list is empty!");
        }
    }
}
