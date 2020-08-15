package case_study.controllers;
import case_study.commons.Regex;
import case_study.models.Constant;
import case_study.models.ExtraService;
import case_study.models.Service;
import case_study.models.Villa;

import java.util.*;

public class VillaManager {
    private List<Service> elementList;

    public VillaManager() {
        elementList = new ArrayList<>();
    }

    public VillaManager(List<Service> elementList) {
        this.elementList = elementList;
    }

    public List<Service> getElementList() {
        return elementList;
    }

    public void setElementList(List<Service> elementList) {
        this.elementList = elementList;
    }

    // Scanner for input from keyboard
    private static Scanner sc = new Scanner(System.in);

    public void addNewVillaService() {
        Villa newElement = new Villa();
        String a,b,c,d,e,f, vh1,vh2,v3,vh4;

        //Extra Service
        String e1 = null, e2 = null, e3 = null;

        //Option to be selected
        int option;

        System.out.println("-- ADD VILLA SERVICE --");
        boolean isValid;
        boolean isExisted = false;

        //Input service Id
        do {
            System.out.print(Constant.INPUT + Constant.STR_A);
            a = sc.nextLine();
            isValid = Regex.validateServiceId(newElement, a);
            if (!isValid) {
                System.out.println(Constant.ID_VILLA_INVALID);
            } else {
                isExisted = Regex.existServiceId(a, elementList);
                if (isExisted) {
                    System.out.println("Service Id " + a + " already exists. Please choose another Id.");
                }
            }
        } while (!isValid || isExisted);

        //Input service name
        do {
            System.out.print(Constant.INPUT + Constant.STR_B);
            b = sc.nextLine();
            isValid = Regex.validateServiceName(b);
            if (!isValid) {
                System.out.println(Constant.NAME_INVALID);
            }
        } while (!isValid);

        //Input used area
        do {
            System.out.print(Constant.INPUT + Constant.STR_C);
            c = sc.nextLine();
            isValid = Regex.validateArea(c);
            if (!isValid) {
                System.out.println(Constant.AREA_INVALID);
            }
        } while(!isValid);

        //Input rent type
        do {
            System.out.print(Constant.INPUT + Constant.STR_D);
            d = sc.nextLine();
            isValid = Regex.validateRentType(d);
            if (!isValid) {
                System.out.println(Constant.RENT_TYPE_INVALID);
            }
        } while(!isValid);

        //Input max people quantity
        do {
            System.out.print(Constant.INPUT + Constant.STR_E);
            e = sc.nextLine();
            isValid = Regex.validateMaxPeopleQty(e);
            if (!isValid) {
                System.out.println(Constant.MAX_QTY_INVALID);
            }
        } while(!isValid);

        //Input rent fee
        do {
        System.out.print(Constant.INPUT + Constant.STR_F);
        f = sc.nextLine();
        isValid = Regex.validateRentFee(f);
            if (!isValid) {
                System.out.println(Constant.RENT_FEE_INVALID);
            }
        } while(!isValid);

        //Add private information for VILLA only
        //Input room standard
        do {
            System.out.print(Constant.INPUT + Constant.STR_VH1);
            vh1 = sc.nextLine();
            isValid = Regex.validateRoomStandard(vh1);
            if (!isValid) {
                System.out.println(Constant.ROOM_STANDARD_INVALID);
            }
        } while(!isValid);

        System.out.print(Constant.INPUT + Constant.STR_VH2);
        option = Integer.parseInt(sc.nextLine());
        switch (option) {
            case 1: vh2 = "Free Laundry"; break;
            case 2: vh2 = "Free Buffet"; break;
            case 3: vh2 = "Free Massage"; break;
            case 4: vh2 = "Free Beverage"; break;
            default: vh2 = "N/A";
        }

        //Input swimming pool area
        do {
            System.out.print(Constant.INPUT + Constant.STR_V3);
            v3 = sc.nextLine();
            isValid = Regex.validateArea(v3);
            if (!isValid) {
                System.out.println(Constant.AREA_INVALID);
            }
        } while(!isValid);

        //Input story number
        do {
            System.out.print(Constant.INPUT + Constant.STR_VH4);
            vh4 = sc.nextLine();
            isValid = Regex.validateStoryNumber(vh4);
            if (!isValid) {
                System.out.println(Constant.STORY_NUMBER_INVALID);
            }
        } while(!isValid);

        System.out.print("Input extra service: Yes(1)? No(0)? ");
        int choose = Integer.parseInt(sc.nextLine());
        if (choose == 1) {
            System.out.println("___Input Extra Service Information___");

            do {
                System.out.print(Constant.INPUT + Constant.STR_E1);
                e1 = sc.nextLine();
                isValid = Regex.validateExtraServiceName(e1);
                if (!isValid) {
                    System.out.println(Constant.NAME_INVALID);
                }
            } while(!isValid);

            System.out.print(Constant.INPUT + Constant.STR_E2);
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1: e2 = "Hour"; break;
                case 2: e2 = "Day"; break;
                case 3: e2 = "Set"; break;
                case 4: e2 = "Combo"; break;
                default: e2 = "N/A";
            }

            System.out.print(Constant.INPUT + Constant.STR_E3);
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1: e3 = "50.0"; break;
                case 2: e3 = "150.0"; break;
                case 3: e3 = "500.0"; break;
                case 4: e3 = "750.0"; break;
                case 5: e3 = "1000.0"; break;
                default: e3 = "0.0";
            }
        }

        ExtraService extraService = new ExtraService(e1,e2,e3);
        newElement = new Villa(a,b,c,d,e,f, vh1,vh2,v3,vh4, extraService);

        newElement.showInfo();

        this.elementList.add(newElement);
    }

    public void displayVillaList() {
        System.out.printf("%-12s%-15s%-12s%-14s%-14s%-12s%-12s%-15s%-15s%-15s%-21s%-11s%s\n","Service_Id",
                "Service_Name", "Used_Area", "Rent_Type", "Max_People", "Rent_Fee", "Room_Std.",
                "Other_Utils", "Sw.Pool_Area", "Story_Number", "Extra_Service_Name", "E.S_Unit", "E.S_Price");
        for (Service element : this.getElementList()) {
            element.showInfo();
        }
        System.out.println(". . . . . . . . . . . . . . . . . . End ELEMENT List . . . . . . . . . . . . . . . . . . .");
    }

    public void deleteVillaService(String id) {
        boolean isFound = false;
        for (Service element : this.elementList) {
            if (id.compareTo(element.getId()) == 0) {
                this.elementList.remove(element);
                element.showInfo();
                isFound = true;
                break;
            }
        }
        if (isFound) {
            System.out.println("*_*_*_ELEMENT id '" + id + "' was removed from the list_*_*_*");
        } else {
            System.out.println("*_*_ELEMENT id '" + id + "' not found in the list_*_*");
        }
    }

    public void displayNonDuplicateVillaNames() {
        Set<String> elementNamesList = new TreeSet<>();
        String elementName = "";

        //get villaName from villaObjectList and add to TreeSet(villaNamesList)
        for (Service element : this.elementList) {
            elementName = element.getServiceName();
            elementNamesList.add(elementName);
        }

        //display non-duplicate villa names in villaNamesList
        System.out.println("--- Not Duplicate Villa Names ---");
        System.out.printf("%-6s%s\n", "No.", "Villa_Name");
        int i = 1;
        for (String eachElementName : elementNamesList) {
            System.out.printf("%-6s%s\n",i + ". ", eachElementName);
            i++;
        }
        System.out.println("----------------------");
    }
}
