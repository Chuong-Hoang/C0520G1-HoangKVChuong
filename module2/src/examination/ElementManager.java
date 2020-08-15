package examination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElementManager {
    private List<Product> elementList;

    public ElementManager() {
        elementList = new ArrayList<>();
    }

    public ElementManager(List<Product> elementList) {
        this.elementList = elementList;
    }

    public List<Product> getElementList() {
        return elementList;
    }

    public void setElementList(List<Product> elementList) {
        this.elementList = elementList;
    }

    /* _________________________________________ Manipulation data _________________________________________________ */
    Scanner sc = new Scanner(System.in);

    //add new
    public void addNewElement() {
        System.out.println("Add new product here.");
        System.out.println("1. Add Import Product");
        System.out.println("2. Add Export Product");
        System.out.println("_______________________");
        System.out.print("Select a number to add: ");
        int option = Integer.parseInt(sc.nextLine());

        //Variables here ************
        String a,b,c,d,e,   i1,i2,i3,    e1,e2;
        Product newElement = null;

        //Input for Variables here***********************
        String stringA = "Code";
        String stringB = "Name";
        String stringC = "Price";
        String stringD = "Quantity";
        String stringE = "Provider";
        String stringI1 = "Import_Price";
        String stringI2 = "Import_Province";
        String stringI3 = "Import_Tax";
        String stringE1 = "Export_Price";
        String stringE2 = "Buying_Country";
        String input = ": Input below -->";
        //End here*************************


        System.out.println(stringA + input);
        a = Regex.checkName(stringA);

        System.out.println(stringB + input);
        b = Regex.checkName(stringB);

        System.out.println(stringC + input);
        c = Regex.checkDouble(stringC);

        System.out.println(stringD + input);
        d = Regex.checkInteger(stringD);

        System.out.println(stringE + input);
        e = Regex.checkName(stringE);

        if (option == 1) {
            System.out.println(stringI1 + input);
            i1 = Regex.checkDouble(stringI1);

            System.out.println(stringI2 + input);
            i2 = Regex.checkName(stringI2);

            System.out.println(stringI3 + input);
            i3 = Regex.checkDouble(stringI3);

            newElement = new ImportProduct(a,b,c,d,e,  i1,i2,i3);

        } else {
            System.out.println(stringE1 + input);
            e1 = Regex.checkDouble(stringE1);

            System.out.println(stringE2 + input);
            e2 = Regex.checkName(stringE2);

            newElement = new ExportProduct(a,b,c,d,e,  e1,e2);
        }

        //**************************Set new ID
        if (this.getElementList().isEmpty()) {
            newElement.setId(1);
        } else {
            newElement.setId(elementList.get(elementList.size() - 1).getId() + 1);
        }

        //show new element added
        System.out.println(newElement.toString());
        elementList.add(newElement);
        System.out.println("Element name '" + b + "' has been added.");
    }

    //delete
    public void deleteAnElement() {
        System.out.print("Input Element Id to be deleted: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean isFound = false;
        Product removedElement = null;
        if (elementList.isEmpty()) {
            System.out.println("Cannot delete any element. The list is empty.");
        } else {
            for (Product element : this.getElementList()) {
                if (id == element.getId()) {
                    removedElement = element;
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                System.out.println("Element with Id '" + id + "' NOT found in the list.");
            } else {
                System.out.print("Delete element name '" + removedElement.getName() + "'? Yes(1) or No(0)? ");
                if (Integer.parseInt(sc.nextLine()) == 1) {
                    elementList.remove(removedElement);

                    //*******************************Reset all ID
                    int i = 1;
                    for (Product element : this.getElementList()) {
                        element.setId(i);
                        i++;
                    }

                } else {
                    System.out.println("No element deleted.");
                }
            }
        }
    }

    //find *****************(code)
    public void findAnElement() {
        System.out.print("Input Element CODE to be searched: ");
        String code = sc.nextLine();
        boolean isFound = false;
        if (elementList.isEmpty()) {
            System.out.println("Cannot find any element. The list is empty.");
        } else {
            for (Product element : this.getElementList()) {
                if (code.compareTo(element.getCode()) == 0) {
                    System.out.println("Element found:");
                    System.out.println(element.toString());
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                System.out.println("Element code '" + code + "' NOT found in the list.");
            }
        }
    }

    //display list
    public void displayAllList() {
        System.out.println("________________________ Elements list __________________________");

        for (Product element : this.getElementList()) {
            System.out.println(element.toString());
        }
        System.out.println("........................... End list ..............................");
    }

    public void findRelativeElement() {
        System.out.print("Input Element first name to be searched: ");
        String name = sc.nextLine().toLowerCase();
        boolean isFound = false;
        if (elementList.isEmpty()) {
            System.out.println("Cannot find any element. The list is empty.");
        } else {
            System.out.println("Result:");
            for (Product element : this.getElementList()) {
                if (element.getName().toLowerCase().contains(name)) {
                    System.out.println(element.toString());
                    isFound = true;
                }
            }

            if (!isFound) {
                System.out.println("Element name with character '" + name + "' NOT found in the list.");
            }
        }
    }

}
