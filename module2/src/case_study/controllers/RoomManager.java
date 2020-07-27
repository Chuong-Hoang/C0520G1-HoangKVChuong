package case_study.controllers;
import case_study.commons.InputValidation;
import case_study.models.ExtraService;
import case_study.models.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomManager {
    private List<Room> roomObjectList;

    public RoomManager() {
        roomObjectList = new ArrayList<>();
    }

    public RoomManager(List<Room> villaList) {
        this.roomObjectList = villaList;
    }

    public List<Room> getRoomObjectList() {
        return roomObjectList;
    }

    public void setRoomObjectList(List<Room> roomObjectList) {
        this.roomObjectList = roomObjectList;
    }

    // Scanner for input from keyboard
    private static Scanner sc = new Scanner(System.in);

    public void addNewRoomService() {
        Room newRoom = new Room();
        String id;
        String serviceName;
        double usedArea;
        String rentType;
        int maxPeopleQuantity;
        double rentFee;
        String freeService;

        //Extra Service
        String extraServiceName = "N/A";
        String extraServiceUnit = "N/A";
        double extraServicePrice = 0.0;

        //Option to be selected
        int option;

        System.out.println("-- ADD ROOM SERVICE --");
        boolean isValid;

        //Input serviceId
        do {
            System.out.print("1.Input service Id: ");
            id = sc.nextLine();
            isValid = InputValidation.validateServiceId(newRoom, id);
            if (!isValid) {
                System.out.println("Input failed! Service Id must be as format 'SVRO-YYYY'");
            }
        } while (!isValid);

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

        //Add private information for ROOM only:
        System.out.print("7.Input free service: (1.Steaming/2.Laundry/3.Phone/4.Gaming): ");
        option = Integer.parseInt(sc.nextLine());
        switch (option) {
            case 1: freeService = "Steaming"; break;
            case 2: freeService = "Laundry"; break;
            case 3: freeService = "Phone"; break;
            case 4: freeService = "Gaming"; break;
            default: freeService = "N/A";
        }


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
        newRoom = new Room(id, serviceName, usedArea, rentFee, maxPeopleQuantity, rentType, freeService, extraService);


        newRoom.showInfo();

        this.roomObjectList.add(newRoom);
    }

    public void displayRoomList() {
        System.out.printf("%-12s%-15s%-12s%-14s%-14s%-12s%-15s%-21s%-11s%s\n","Service_Id",
                "Service_Name", "Used_Area", "Rent_Type", "Max_People", "Rent_Fee",
                "Free_Service", "Extra_Service_Name", "E.S_Unit", "E.S_Price");
        for (Room room : this.roomObjectList) {
           room.showInfo();
        }
        System.out.println(". . . . . . . . . . . . . . . . . . End ROOM List . . . . . . . . . . . . . . . . . . .");
    }

    public void deleteRoomService(String id) {
        boolean isFound = false;
        for (Room villa : roomObjectList) {
            if (id.compareTo(villa.getId()) == 0) {
                roomObjectList.remove(villa);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            System.out.println("*_*_*_Room service id '" + id + "' was removed from the list_*_*_*");
        } else {
            System.out.println("*_*_Room service id '" + id + "' not found in the list_*_*");
        }
    }
}
