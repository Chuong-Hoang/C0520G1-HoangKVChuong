package case_study.controllers;
import case_study.models.ExtraService;
import case_study.models.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RoomUtils {
    private static List<Room> roomObjectList = new ArrayList<>();

    // Create file name
    private static final String ROOM_FILE_PATH = "src/case_study/data/Room.csv";

    // Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    // File header in CSV file
    private static final String FILE_HEADER = "Id, Service Name, Used Area, Rent Amount, Max People Quantity," +
            "Rent Type, Free Service, Extra Service Name, Extra Service Unit, Extra Service Price";

    // Create room file
    private static File roomCsvFile = new File(ROOM_FILE_PATH);

    public static List<Room> readRoomFile() {
        try {
            if (!roomCsvFile.exists()) {
                System.out.println("File does not exist.");
            } else {
                FileReader fileReader = new FileReader(roomCsvFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                Room outputRoom = null;
                String[] roomStringArray;
                String roomString;
                String id;
                String serviceName;
                double usedArea;
                double rentFee;
                int maxPeopleQuantity;
                String rentType;
                String freeService;

                ExtraService extraService;
                String extraServiceName = "N/A";
                String extraServiceUnit = "N/A";
                double extraServicePrice = 0.0;

                //clear roomObjectList for re-writing all objects
                roomObjectList.clear();

                //roomString = bufferedReader.readLine(); // read the FILE_HEADER

                while ((roomString = bufferedReader.readLine()) != null) {
                    //System.out.println(roomString);

                    //change each roomString into array:
                    roomStringArray = roomString.split(",");

                    //get array elements and assign to room object's attributes
                    id = roomStringArray[0];
                    serviceName = roomStringArray[1];
                    usedArea = Double.parseDouble(roomStringArray[2]);
                    rentFee = Double.parseDouble(roomStringArray[3]);
                    maxPeopleQuantity = Integer.parseInt(roomStringArray[4]);
                    rentType = roomStringArray[5];
                    freeService = roomStringArray[6];

                    if (roomStringArray.length > 7) {
                        extraServiceName = roomStringArray[7];
                        extraServiceUnit = roomStringArray[8];
                        extraServicePrice = Double.parseDouble(roomStringArray[9]);
                    }

                    // create an instance of ExtraService class
                    extraService = new ExtraService(extraServiceName, extraServiceUnit, extraServicePrice);

                    // create an Room object
                    outputRoom = new Room(id, serviceName, usedArea, rentFee, maxPeopleQuantity, rentType,
                            freeService, extraService);

                    // add each Room object into roomObjectList
                    roomObjectList.add(outputRoom);

                }

                fileReader.close();
                bufferedReader.close();
            }

        } catch (IOException e) {
            System.out.println("Error --> " + e);
        }
        return roomObjectList;
    }

    public static void writeRoomFile(List<Room> roomObjectList) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (!roomCsvFile.exists()) {
                fileWriter = new FileWriter(roomCsvFile);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.append(FILE_HEADER);
                bufferedWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter = new FileWriter(roomCsvFile.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);

            if (!roomObjectList.isEmpty()) {
                for (Room room : roomObjectList) {
                    stringBuilder.append(room.getId());  //1
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(room.getServiceName());  //2
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(String.valueOf(room.getUsedArea()));  //3
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(String.valueOf(room.getRentFee()));  //4
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(String.valueOf(room.getMaxPeopleQuantity()));  //5
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(room.getRentType());  //6
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(room.getFreeService());  //7

                    //if (villa.getExtraService() != null) {
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(room.getExtraService().getExtraServiceName());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(room.getExtraService().getExtraServiceUnit());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(String.valueOf(room.getExtraService().getExtraServicePrice()));
                    // }
                    stringBuilder.append(NEW_LINE_SEPARATOR);
                }
                bufferedWriter.append(stringBuilder);
                //villaObjectList.clear();
            } else {
                System.out.println("The list is empty. Please add New Room Service.");
            }

            fileWriter.flush();
            bufferedWriter.flush();
            fileWriter.close();
            bufferedWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
