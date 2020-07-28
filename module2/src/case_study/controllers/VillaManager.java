package case_study.controllers;
import case_study.commons.InputValidation;
import case_study.models.ExtraService;
import case_study.models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VillaManager {
    private List<Villa> villaObjectList;

    public VillaManager() {
        villaObjectList = new ArrayList<>();
    }

    public VillaManager(List<Villa> villaList) {
        this.villaObjectList = villaList;
    }

    public List<Villa> getVillaObjectList() {
        return villaObjectList;
    }

    public void setVillaObjectList(List<Villa> villaObjectList) {
        this.villaObjectList = villaObjectList;
    }

    // Scanner for input from keyboard
    private static Scanner sc = new Scanner(System.in);

    public void addNewVillaService() {
        Villa newVilla = new Villa();
        String id;
        String serviceName;
        double usedArea;
        String rentType;
        int maxPeopleQuantity;
        double rentFee;
        String roomStandard;
        String otherUtility;
        double swimmingPoolArea;
        int storyNumber;

        //Extra Service
        String extraServiceName = "N/A";
        String extraServiceUnit = "N/A";
        double extraServicePrice = 0.0;

        //Option to be selected
        int option;

        System.out.println("-- ADD VILLA SERVICE --");
        boolean isValid;
        boolean isExisted = false;

        //Input serviceId
        do {
            System.out.print("1.Input service Id: ");
            id = sc.nextLine();
            isValid = InputValidation.validateServiceId(newVilla, id);
            if (!isValid) {
                System.out.println("Input failed! Service Id must be as format 'SVVL-YYYY'");
            } else {
                isExisted = InputValidation.existServiceId(id, villaObjectList);
                if (isExisted) {
                    System.out.println("Service Id " + id + " already exists. Please choose another Id.");
                }
            }
        } while (!isValid || isExisted);

        //Input service name
        do {
            System.out.print("2.Input service name: ");
            serviceName = sc.nextLine();
            isValid = InputValidation.validateServiceName(serviceName);
            if (!isValid) {
                System.out.println("Input failed! Service Name must follow Camelcase");
            }
        } while (!isValid);

        //Input used area
        do {
            System.out.print("3.Input used area: ");
            usedArea = Double.parseDouble(sc.nextLine());
            isValid = InputValidation.validateArea(String.valueOf(usedArea));
            if (!isValid) {
                System.out.println("Input failed! Used area must be float number that greater than 30m2.");
            }
        } while(!isValid);

        //Input rent type
        do {
            System.out.print("4.Input rent type (Hourly/Daily/Monthly/Yearly): ");
            rentType = sc.nextLine();
            isValid = InputValidation.validateRentType(rentType);
            if (!isValid) {
                System.out.println("Input failed! Rent Type must follow Camelcase");
            }
        } while(!isValid);

        //Input max people quantity
        do {
            System.out.print("5.Input max people quantity: ");
            maxPeopleQuantity = Integer.parseInt(sc.nextLine());
            isValid = InputValidation.validateMaxPeopleQty(String.valueOf(maxPeopleQuantity));
            if (!isValid) {
                System.out.println("Input failed! Max people number must be positive and less than 20.");
            }
        } while(!isValid);

        //Input rent fee
        do {
        System.out.print("6.Input rent fee: ");
        rentFee = Double.parseDouble(sc.nextLine());
        isValid = InputValidation.validateRentFee(String.valueOf(rentFee));
            if (!isValid) {
                System.out.println("Input failed! Rent fee must be a positive number.");
            }
        } while(!isValid);

        //Add private information for VILLA only
        //Input room standard
        do {
            System.out.print("7.Input room standard (Vip/Business/Normal): ");
            roomStandard = sc.nextLine();
            isValid = InputValidation.validateRoomStandard(roomStandard);
            if (!isValid) {
                System.out.println("Input failed! Room standard must follow Camelcase.");
            }
        } while(!isValid);

        System.out.print("8.Input other utility (1.Free Laundry/2.Free Buffet/3.Free Massage/4.Free Beverage): ");
        option = Integer.parseInt(sc.nextLine());
        switch (option) {
            case 1: otherUtility = "Free Laundry"; break;
            case 2: otherUtility = "Free Buffet"; break;
            case 3: otherUtility = "Free Massage"; break;
            case 4: otherUtility = "Free Beverage"; break;
            default: otherUtility = "N/A";
        }

        //Input swimming pool area
        do {
            System.out.print("9.Input swimming pool area: ");
            swimmingPoolArea = Double.parseDouble(sc.nextLine());
            isValid = InputValidation.validateArea(String.valueOf(swimmingPoolArea));
            if (!isValid) {
                System.out.println("Input failed! Area must be float number that greater than 30m2.");
            }
        } while(!isValid);

        //Input story number
        do {
            System.out.print("10.Input story number: ");
            storyNumber = Integer.parseInt(sc.nextLine());
            isValid = InputValidation.validateStoryNumber(String.valueOf(storyNumber));
            if (!isValid) {
                System.out.println("Input failed! Story number must be a positive integer.");
            }
        } while(!isValid);

        System.out.print("Input extra service: Yes(1)? No(0)? ");
        int choose = Integer.parseInt(sc.nextLine());
        if (choose == 1) {
            System.out.println("__Input extra service information__");

            do {
                System.out.print("Input extra service name (Karaoke/Massage/Food/Drink/Car): ");
                extraServiceName = sc.nextLine();
                isValid = InputValidation.validateExtraServiceName(extraServiceName);
                if (!isValid) {
                    System.out.println("Input failed! Name must follow Camelcase.");
                }
            } while(!isValid);

            System.out.print("Input extra service unit (1.Hour/2.Day/3.Set/4.Combo): ");
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1: extraServiceUnit = "Hour"; break;
                case 2: extraServiceUnit = "Day"; break;
                case 3: extraServiceUnit = "Set"; break;
                case 4: extraServiceUnit = "Combo"; break;
                default: extraServiceUnit = "N/A";
            }

            System.out.print("Input extra service price (1.$50/2.$150/3.$500/4.$750/5.$1000): ");
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1: extraServicePrice = 50.0; break;
                case 2: extraServicePrice = 150.0; break;
                case 3: extraServicePrice = 500.0; break;
                case 4: extraServicePrice = 750.0; break;
                case 5: extraServicePrice = 1000.0; break;
                default: extraServicePrice = 0.0;
            }
        }

        ExtraService extraService = new ExtraService(extraServiceName, extraServiceUnit, extraServicePrice);
        newVilla = new Villa(id, serviceName, usedArea, rentFee, maxPeopleQuantity, rentType,
                    roomStandard, otherUtility, swimmingPoolArea, storyNumber, extraService);

        newVilla.showInfo();

        this.villaObjectList.add(newVilla);
    }

    public void displayVillaList() {
        System.out.printf("%-12s%-15s%-12s%-14s%-14s%-12s%-12s%-15s%-15s%-15s%-21s%-11s%s\n","Service_Id",
                "Service_Name", "Used_Area", "Rent_Type", "Max_People", "Rent_Fee", "Room_Std.",
                "Other_Utils", "Sw.Pool_Area", "Story_Number", "Extra_Service_Name", "E.S_Unit", "E.S_Price");
        for (Villa villa : this.villaObjectList) {
            villa.showInfo();
        }
        System.out.println(". . . . . . . . . . . . . . . . . . End Villa List . . . . . . . . . . . . . . . . . . .");
    }

    public void deleteVillaService(String id) {
        boolean isFound = false;
        for (Villa villa : this.villaObjectList) {
            if (id.compareTo(villa.getId()) == 0) {
                this.villaObjectList.remove(villa);
                villa.showInfo();
                isFound = true;
                break;
            }
        }
        if (isFound) {
            System.out.println("*_*_*_Villa service id '" + id + "' was removed from the list_*_*_*");
        } else {
            System.out.println("*_*_Villa service id '" + id + "' not found in the list_*_*");
        }
    }
}
