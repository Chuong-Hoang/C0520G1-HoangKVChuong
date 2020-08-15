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

        System.out.println(Constant.STR_A + Constant.INPUT);
        a = Regex.checkName(Constant.STR_A);

        System.out.println(Constant.STR_B + Constant.INPUT);
        b = Regex.checkName(Constant.STR_B);

        System.out.println(Constant.STR_C + Constant.INPUT);
        c = Regex.checkDouble(Constant.STR_C);

        System.out.println(Constant.STR_D + Constant.INPUT);
        d = Regex.checkInteger(Constant.STR_D);

        System.out.println(Constant.STR_E + Constant.INPUT);
        e = Regex.checkName(Constant.STR_E);

        if (option == 1) {
            System.out.println(Constant.STR_I1 + Constant.INPUT);
            i1 = Regex.checkDouble(Constant.STR_I1);

            System.out.println(Constant.STR_I2 + Constant.INPUT);
            i2 = Regex.checkName(Constant.STR_I2);

            System.out.println(Constant.STR_I3 + Constant.INPUT);
            i3 = Regex.checkDouble(Constant.STR_I3);

            newElement = new ImportProduct(a,b,c,d,e,  i1,i2,i3);

        } else {
            System.out.println(Constant.STR_E1 + Constant.INPUT);
            e1 = Regex.checkDouble(Constant.STR_E1);

            System.out.println(Constant.STR_E2 + Constant.INPUT);
            e2 = Regex.checkName(Constant.STR_E2);

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
        System.out.println(Constant.NEW_ELEMENT_ADDED);
    }

    //delete
    public void deleteAnElement() {
        System.out.print("Input Element Id to be deleted: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean isFound = false;
        Product removedElement = null;
        if (elementList.isEmpty()) {
            System.out.println(Constant.CANNOT_DELETE_ELEMENT);
        } else {
            for (Product element : this.getElementList()) {
                if (id == element.getId()) {
                    System.out.println(Constant.RESULT);
                    System.out.println(removedElement.toString());
                    removedElement = element;
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                System.out.println(Constant.ELEMENT_NOT_FOUND);
            } else {
                System.out.print(Constant.DELETE_OR_NOT);
                if (Constant.YES.compareTo(sc.nextLine().toLowerCase()) == 0) {
                    elementList.remove(removedElement);

                    //*******************************Reset all ID
                    int i = 1;
                    for (Product element : this.getElementList()) {
                        element.setId(i);
                        i++;
                    }
                } else {
                    System.out.println(Constant.NO_ELEMENT_DELETED);
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
            System.out.println(Constant.CANNOT_FIND_ELEMENT);
        } else {
            for (Product element : this.getElementList()) {
                if (code.compareTo(element.getCode()) == 0) {
                    System.out.println(Constant.RESULT);
                    System.out.println(element.toString());
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println(Constant.ELEMENT_NOT_FOUND);
            }
        }
    }

    //display list
    public void displayAllList() {
        System.out.println(Constant.LIST_BEGUN);

        for (Product element : this.getElementList()) {
            System.out.println(element.toString());
        }
        System.out.println(Constant.LIST_ENDED);
    }

    public void findRelativeElement() {
        System.out.print("Input Element first name to be searched: ");
        String name = sc.nextLine().toLowerCase();
        boolean isFound = false;
        if (elementList.isEmpty()) {
            System.out.println(Constant.CANNOT_FIND_ELEMENT);
        } else {
            System.out.println(Constant.RESULT);
            for (Product element : this.getElementList()) {
                if (element.getName().toLowerCase().contains(name)) {
                    System.out.println(element.toString());
                    isFound = true;
                }
            }

            if (!isFound) {
                System.out.println(Constant.ELEMENT_NOT_FOUND);
            }
        }
    }

}
