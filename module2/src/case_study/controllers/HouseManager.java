package case_study.controllers;

import case_study.commons.Regex;
import case_study.models.ExtraService;
import case_study.models.House;
import case_study.models.Service;

import java.util.*;

public class HouseManager {
    private List<Service> elementList;

    public HouseManager() {
        elementList = new ArrayList<>();
    }

    public HouseManager(List<Service> elementList) {
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

    public void addNewHouseService() {
        House newElement = new House();
        String a,b,c,d,e,f,  vh1,vh2,vh4;

        //Extra Service
        String e1 = null, e2 = null, e3 = null;

        //Option to be selected
        int option;

        System.out.println("-- ADD HOUSE SERVICE --");
        boolean isValid;
        boolean isExisted = false;

        //Input serviceId
        do {
            System.out.print(Service.input + Service.strA);
            a = sc.nextLine();
            isValid = Regex.validateServiceId(newElement, a);
            if (!isValid) {
                System.out.println(Service.idHouseNotValid);
            } else {
                isExisted = Regex.existServiceId(a, elementList);
                if (isExisted) {
                    System.out.println("Service Id " + a + " already exists. Please choose another Id.");
                }
            }
        } while (!isValid || isExisted);

        //Input service name
        do {
            System.out.print(Service.input + Service.strB);
            b = sc.nextLine();
            isValid = Regex.validateServiceName(b);
            if (!isValid) {
                System.out.println(Service.nameNotValid);
            }
        } while (!isValid);

        //Input used area
        do {
            System.out.print(Service.input + Service.strC);
            c = sc.nextLine();
            isValid = Regex.validateArea(c);
            if (!isValid) {
                System.out.println(Service.areaNotValid);
            }
        } while(!isValid);

        //Input rent type
        do {
            System.out.print(Service.input + Service.strD);
            d = sc.nextLine();
            isValid = Regex.validateRentType(d);
            if (!isValid) {
                System.out.println(Service.rentTypeNotValid);
            }
        } while(!isValid);

        //Input max people quantity
        do {
            System.out.print(Service.input + Service.strE);
            e = sc.nextLine();
            isValid = Regex.validateMaxPeopleQty(e);
            if (!isValid) {
                System.out.println(Service.maxQtyNotValid);
            }
        } while(!isValid);

        //Input rent fee
        do {
            System.out.print(Service.input + Service.strF);
            f = sc.nextLine();
            isValid = Regex.validateRentFee(f);
            if (!isValid) {
                System.out.println(Service.rentFeeNotValid);
            }
        } while(!isValid);

        //Add private information for HOUSE only
        //Input room standard
        do {
            System.out.print(Service.input + Service.strVH1);
            vh1 = sc.nextLine();
            isValid = Regex.validateRoomStandard(vh1);
            if (!isValid) {
                System.out.println(Service.roomStandardNotValid);
            }
        } while(!isValid);

        System.out.print(Service.input + Service.strVH2);
        option = Integer.parseInt(sc.nextLine());
        switch (option) {
            case 1: vh2 = "Free Laundry"; break;
            case 2: vh2 = "Free Buffet"; break;
            case 3: vh2 = "Free Massage"; break;
            case 4: vh2 = "Free Beverage"; break;
            default: vh2 = "N/A";
        }

        //Input story number
        do {
            System.out.print(Service.input + Service.strVH4);
            vh4 = sc.nextLine();
            isValid = Regex.validateStoryNumber(vh4);
            if (!isValid) {
                System.out.println(Service.storyNumberNotValid);
            }
        } while(!isValid);

        System.out.print("Input extra service: Yes(1)? No(0)? ");
        int choose = Integer.parseInt(sc.nextLine());
        if (choose == 1) {
            System.out.println("__Input extra service information__");

            do {
                System.out.print(Service.input + Service.strE1);
                e1 = sc.nextLine();
                isValid = Regex.validateExtraServiceName(e1);
                if (!isValid) {
                    System.out.println(Service.nameNotValid);
                }
            } while(!isValid);

            System.out.print(Service.input + Service.strE2);
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1: e2 = "Hour"; break;
                case 2: e2 = "Day"; break;
                case 3: e2 = "Set"; break;
                case 4: e2 = "Combo"; break;
                default: e2 = "N/A";
            }

            System.out.print(Service.input + Service.strE3);
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
        newElement = new House(a,b,c,d,e,f,   vh1,vh2,vh4,  extraService);

        newElement.showInfo();

        this.elementList.add(newElement);
    }

    public void displayHouseList() {
        System.out.printf("%-12s%-15s%-12s%-14s%-14s%-12s%-12s%-15s%-15s%-21s%-11s%s\n","Service_Id",
                "Service_Name", "Used_Area", "Rent_Type", "Max_People", "Rent_Fee", "Room_Std.",
                "Other_Utils", "Story_Number", "Extra_Service_Name", "E.S_Unit", "E.S_Price");
        for (Service element : this.getElementList()) {
            element.showInfo();
        }
        System.out.println(". . . . . . . . . . . . . . . . . .  End ELEMENT List . . . . . . . . . . . . . . . . . . .");
    }

    public void deleteHouseService(String id) {
        boolean isFound = false;
        for (Service element : elementList) {
            if (id.compareTo(element.getId()) == 0) {
                elementList.remove(element);
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

    public void displayNonDuplicateHouseNames() {
        Set<String> elementNamesList = new TreeSet<>();

        //Get house name from houseObjectList and add to TreeSet
        String elementName = "";
        for (Service element : this.elementList) {
            elementName = element.getServiceName();
            elementNamesList.add(elementName);
        }

        //Display house names in the TreeSet
        System.out.println("---Not Duplicate House Names---");
        System.out.printf("%-6s%s\n", "No.", "House_Name");
        int i = 1;
        for (String eachElementName : elementNamesList) {
            System.out.printf("%-6s%s\n", i+". ", eachElementName);
            i++;
        }
        System.out.println("-----------------------");
    }
}
