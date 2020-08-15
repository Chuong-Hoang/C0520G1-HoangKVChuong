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

        System.out.println(Constant.STR_E2 + Constant.INPUT);
        a = Validation.checkPhoneNumber();
        if (checkExistingNumber(a)) {
            System.out.println(Constant.ELEMENT_ALREADY_EXISTS);
            addNewElement();
        } else {

            System.out.println(Constant.STR_B + Constant.INPUT);
            b = Validation.checkName(Constant.STR_B);

            System.out.println(Constant.STR_C + Constant.INPUT);
            c = Validation.checkName(Constant.STR_C);

            System.out.println(Constant.STR_D + Constant.INPUT);
            d = Validation.checkName(Constant.STR_D);

            System.out.println(Constant.STR_E + Constant.INPUT);
            e = Validation.checkName(Constant.STR_E);

            System.out.println(Constant.STR_E1 + Constant.INPUT);
            e1 = Validation.checkBirthday();

            System.out.println(Constant.STR_E2 + Constant.INPUT);
            e2 = Validation.checkEmail();

            newElement = new Contact(a, b, c, d, e, e1, e2);

            //show new element added
            System.out.println(newElement.toString());
            elementList.add(newElement);
            System.out.println(Constant.NEW_ELEMENT_ADDED);
        }
    }

    //update
    public void updateAnElement() {
        System.out.print("Input Element number to be update: ");
        String number = sc.nextLine().toLowerCase();
        boolean isFound = false;
        Contact updatedElement = null;
        if (elementList.isEmpty()) {
            System.out.println(Constant.CANNOT_FIND_ELEMENT);
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
                System.out.println(Constant.ELEMENT_NOT_FOUND);
            } else {
                String a, b, c, d, e, e1, e2;
                //Input for Variables here***********************

                System.out.println("_____Update Information_____");
                System.out.println(1 + Constant.UPDATE + Constant.STR_A);
                System.out.println(2 + Constant.UPDATE + Constant.STR_B);
                System.out.println(3 + Constant.UPDATE + Constant.STR_C);
                System.out.println(4 + Constant.UPDATE + Constant.STR_D);
                System.out.println(5 + Constant.UPDATE + Constant.STR_E);
                System.out.println(6 + Constant.UPDATE + Constant.STR_E1);
                System.out.println(7 + Constant.UPDATE + Constant.STR_E2);
                System.out.println("0.Back to main menu");
                System.out.println("............................");
                System.out.print("=>Select an option: ");
                int option = Integer.parseInt(sc.nextLine());

                switch (option) {
                    case 1:
                        //Update a
                        System.out.println(Constant.STR_A + Constant.RE_INPUT);
                        a = Validation.checkPhoneNumber();
                        if (checkExistingNumber(a)) {
                            System.out.println(Constant.ELEMENT_ALREADY_EXISTS);
                            updateAnElement();
                        } else {
                            updatedElement.setPhoneNumber(a);
                        }
                        break;
                    case 2:
                        //Update b
                        System.out.println(Constant.STR_B + Constant.RE_INPUT);
                        b = Validation.checkName(Constant.STR_B);
                        updatedElement.setGroup(b);
                        break;
                    case 3:
                        //Update c
                        System.out.println(Constant.STR_C + Constant.RE_INPUT);
                        c = Validation.checkName(Constant.STR_C);
                        updatedElement.setFullName(c);
                        //c
                        break;
                    case 4:
                        //Update d
                        System.out.println(Constant.STR_D + Constant.RE_INPUT);
                        d = Validation.checkName(Constant.STR_D);
                        updatedElement.setGender(d);
                        break;
                    case 5:
                        //Update e
                        System.out.println(Constant.STR_E + Constant.RE_INPUT);
                        e = Validation.checkName(Constant.STR_E);
                        updatedElement.setAddress(e);
                        break;
                    case 6:
                        //Update e1
                        System.out.println(Constant.STR_E1 + Constant.RE_INPUT);
                        e1 = Validation.checkBirthday();
                        updatedElement.setBirthday(e1);
                        break;
                    case 7:
                        //Update e2
                        System.out.println(Constant.STR_E2 + Constant.RE_INPUT);
                        e2 = Validation.checkEmail();
                        updatedElement.setEmail(e2);
                        break;
                    case 0:
                    default:
                        //Main menu
                        break;
                }
                //Show after update
                System.out.println(Constant.RESULT_UPDATE);
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
            System.out.println(Constant.CANNOT_DELETE_ELEMENT);
        } else {
            for (Contact element : this.getElementList()) {
                if (number.compareTo(element.getPhoneNumber()) == 0) {
                    removedElement = element;
                    System.out.println(removedElement.toString());
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
                } else {
                    System.out.println(Constant.NO_ELEMENT_DELETED);
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
            System.out.println(Constant.CANNOT_FIND_ELEMENT);
        } else {
            System.out.println(Constant.RESULT);
            for (Contact element : this.getElementList()) {
                if (element.getFullName().toLowerCase().contains(name)) {
                    System.out.println(element.toString());
                    isFound = true;
                    //break;
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

        int i = 1;
        for (Contact element : this.getElementList()) {
            System.out.print(i + ". ");
            System.out.println(element.toString());
            i++;
        }
        System.out.println(Constant.LIST_ENDED);
    }

    public void findRelativeElement() {
        System.out.print("Input a group of number to be relatively searched: ");
        String number = sc.nextLine();
        boolean isFound = false;
        if (elementList.isEmpty()) {
            System.out.println(Constant.CANNOT_FIND_ELEMENT);
        } else {
            System.out.println(Constant.RESULT);
            for (Contact element : this.getElementList()) {
                if (element.getPhoneNumber().contains(number)) {
                    System.out.println(element.toString());
                    isFound = true;
                }
            }

            if (!isFound) {
                System.out.println(Constant.ELEMENT_NOT_FOUND);
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
