package final_exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElementManager {
    private List<Contact> elementList;

    public ElementManager() {
        elementList = new ArrayList<>();
    }

    public ElementManager(List<Contact> elementList) {
        this.elementList = elementList;
    }

    public List<Contact> getElementList() {
        return elementList;
    }

    public void setElementList(List<Contact> elementList) {
        this.elementList = elementList;
    }

    /* _________________________________________ Manipulation data _________________________________________________ */
    Scanner sc = new Scanner(System.in);

    //add new
    public void addNewElement() {
        System.out.println("Add new contact here.");

        //Variables here ************
        String a, b, c, d, e, e1, e2;
        Contact newElement = null;

        //Input for Variables here***********************
        String stringA = "Phone_Number";
        String stringB = "Group";
        String stringC = "Full_Name";
        String stringD = "Gender";
        String stringE = "Address";

        String stringE1 = "Birthday";
        String stringE2 = "Email";

        String input = ": Input as below -->";
        //End here*************************


        System.out.println(stringA + input);
        a = Validation.checkPhoneNumber();

        if (checkExistingNumber(a)) {
            System.out.println("This number is already in the list. Please input another number.");
            addNewElement();
        } else {

            System.out.println(stringB + input);
            b = Validation.checkName(stringB);

            System.out.println(stringC + input);
            c = Validation.checkName(stringC);

            System.out.println(stringD + input);
            d = Validation.checkName(stringD);

            System.out.println(stringE + input);
            e = Validation.checkName(stringE);

            System.out.println(stringE1 + input);
            e1 = Validation.checkBirthday();

            System.out.println(stringE2 + input);
            e2 = Validation.checkEmail();

            newElement = new Contact(a, b, c, d, e, e1, e2);

            //show new element added
            System.out.println(newElement.toString());
            elementList.add(newElement);
            System.out.println("Element number '" + a + "' has been added.");
        }
    }

    //update
    public void updateAnElement() {
        System.out.print("Input Element number to be update: ");
        String number = sc.nextLine().toLowerCase();
        boolean isFound = false;
        Contact updatedElement = null;
        if (elementList.isEmpty()) {
            System.out.println("Cannot find any element. The list is empty.");
        } else {
            for (Contact element : this.getElementList()) {
                if (number.compareTo(element.getPhoneNumber()) == 0) {
                    updatedElement = element;
                    System.out.println(updatedElement.toString());
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                System.out.println("Element with number '" + number + "' NOT found in the list.");
            } else {
                String a, b, c, d, e, e1, e2;
                //Input for Variables here***********************
                String stringA = "Phone_Number";
                String stringB = "Group";
                String stringC = "Full_Name";
                String stringD = "Gender";
                String stringE = "Address";

                String stringE1 = "Birthday";
                String stringE2 = "Email";

                String input = ": Input New Information -->";
                //End here***************************************

                String update = ".Update ";

                System.out.println("_____Update Information_____");
                System.out.println(1 + update + stringA);
                System.out.println(2 + update + stringB);
                System.out.println(3 + update + stringC);
                System.out.println(4 + update + stringD);
                System.out.println(5 + update + stringE);
                System.out.println(6 + update + stringE1);
                System.out.println(7 + update + stringE2);
                System.out.println("0.Back to main menu");
                System.out.println("............................");
                System.out.print("=>Select an option: ");
                int option = Integer.parseInt(sc.nextLine());

                switch (option) {
                    case 1:
                        //Update a
                        System.out.println(stringA + input);
                        a = Validation.checkPhoneNumber();

                        if (checkExistingNumber(a)) {
                            System.out.println("This number is already in the list...");
                            updateAnElement();
                        } else {
                            updatedElement.setPhoneNumber(a);
                        }
                        break;
                    case 2:
                        //Update b
                        System.out.println(stringB + input);
                        b = Validation.checkName(stringB);
                        updatedElement.setGroup(b);
                        break;
                    case 3:
                        //Update c
                        System.out.println(stringC + input);
                        c = Validation.checkName(stringC);
                        updatedElement.setFullName(c);
                        //c
                        break;
                    case 4:
                        //Update d
                        System.out.println(stringD + input);
                        d = Validation.checkName(stringD);
                        updatedElement.setGender(d);
                        break;
                    case 5:
                        //Update e
                        System.out.println(stringE + input);
                        e = Validation.checkName(stringE);
                        updatedElement.setAddress(e);
                        break;
                    case 6:
                        //Update e1
                        System.out.println(stringE1 + input);
                        e1 = Validation.checkBirthday();
                        updatedElement.setBirthday(e1);
                        break;
                    case 7:
                        //Update e2
                        System.out.println(stringE2 + input);
                        e2 = Validation.checkEmail();
                        updatedElement.setEmail(e2);
                        break;
                    case 0:
                    default:
                        //Main menu
                        break;
                }
                //Show after update
                System.out.println("New update:");
                System.out.println(updatedElement.toString());
            }
        }
    }

    //delete
    public void deleteAnElement() {
        System.out.print("Input Element NUMBER to be deleted: ");
        String number = sc.nextLine();
        boolean isFound = false;
        Contact removedElement = null;
        if (elementList.isEmpty()) {
            System.out.println("Cannot delete any element. The list is empty.");
        } else {
            for (Contact element : this.getElementList()) {
                if (number.compareTo(element.getPhoneNumber()) == 0) {
                    removedElement = element;
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                System.out.println("Element with number '" + number + "' NOT found in the list.");
            } else {
                System.out.print("Delete element number '" + number + "'? Yes(y) or No(n)? ");
                if ("Y".toLowerCase().compareTo(sc.nextLine()) == 0) {
                    elementList.remove(removedElement);
                } else {
                    System.out.println("No element deleted.");
                }
            }
        }
    }

    //find *****************(number)
    public void findAnElementByName() {
        System.out.print("Input Element Name to be relatively searched: ");
        String name = sc.nextLine().toLowerCase();
        boolean isFound = false;
        if (elementList.isEmpty()) {
            System.out.println("Cannot find any element. The list is empty.");
        } else {
            System.out.println("Result:");
            for (Contact element : this.getElementList()) {
                if (element.getFullName().toLowerCase().contains(name)) {
                    System.out.println(element.toString());
                    isFound = true;
                    //break;
                }
            }

            if (!isFound) {
                System.out.println("Element name '" + name + "' NOT found in the list.");
            }
        }
    }

    //display list
    public void displayAllList() {
        System.out.println("________________________ Elements list __________________________");

        int i = 1;
        for (Contact element : this.getElementList()) {
            System.out.print(i + ". ");
            System.out.println(element.toString());
            i++;
        }
        System.out.println("........................... End list ..............................");
    }

    public void findRelativeElement() {
        System.out.print("Input a group of number to be relatively searched: ");
        String number = sc.nextLine();
        boolean isFound = false;
        if (elementList.isEmpty()) {
            System.out.println("Cannot find any element. The list is empty.");
        } else {
            System.out.println("Result:");
            for (Contact element : this.getElementList()) {
                if (element.getPhoneNumber().contains(number)) {
                    System.out.println(element.toString());
                    isFound = true;
                }
            }

            if (!isFound) {
                System.out.println("Element number '" + number + "' NOT found in the list.");
            }
        }
    }

    public boolean checkExistingNumber(String number) {
        boolean isExisting = false;
        for (Contact element : this.getElementList()) {
            if (number.compareTo(element.getPhoneNumber()) == 0) {
                isExisting = true;
                break;
            }
        }
        return isExisting;
    }

}
