package case_study.controllers;
import case_study.models.ExtraService;
import case_study.models.House;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HouseUtils {
    private static List<House> houseObjectList = new ArrayList<>();

    // Create file name
    private static final String HOUSE_FILE_PATH = "src/case_study/data/House.csv";

    // Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    // File header in CSV file
    private static final String FILE_HEADER = "Id, Service Name, Used Area, Rent Amount, Max People Quantity," +
            "Rent Type, Room Standard, Other Utility, Story Number, " +
            "Extra Service Name, Extra Service Unit, Extra Service Price";

    // Create villa file
    private static File houseCsvFile = new File(HOUSE_FILE_PATH);

    public static List<House> readHouseFile() {
        try {
            if (!houseCsvFile.exists()) {
                System.out.println("File does not exist.");
            } else {
                FileReader fileReader = new FileReader(houseCsvFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                House outputHouse = null;
                String[] houseStringArray;
                String houseString;
                String id;
                String serviceName;
                double usedArea;
                double rentFee;
                int maxPeopleQuantity;
                String rentType;
                String roomStandard;
                String otherUtility;
                int storyNumber;
                ExtraService extraService;
                String extraServiceName = "N/A";
                String extraServiceUnit = "N/A";
                double extraServicePrice = 0.0;

                //clear houseObjectList for re-writing all objects
                houseObjectList.clear();

                //houseString = bufferedReader.readLine(); // read the FILE_HEADER

                while ((houseString = bufferedReader.readLine()) != null) {
                    //System.out.println(villaString);

                    //change each villaString into array:
                    houseStringArray = houseString.split(",");

                    //get array elements and assign to villa object's attributes
                    id = houseStringArray[0];
                    serviceName = houseStringArray[1];
                    usedArea = Double.parseDouble(houseStringArray[2]);
                    rentFee = Double.parseDouble(houseStringArray[3]);
                    maxPeopleQuantity = Integer.parseInt(houseStringArray[4]);
                    rentType = houseStringArray[5];
                    roomStandard = houseStringArray[6];
                    otherUtility = houseStringArray[7];
                    storyNumber = Integer.parseInt(houseStringArray[8]);

                    if (houseStringArray.length > 9) {
                        extraServiceName = houseStringArray[9];
                        extraServiceUnit = houseStringArray[10];
                        extraServicePrice = Double.parseDouble(houseStringArray[11]);
                    }

                    // create an instance of ExtraService class
                    extraService = new ExtraService(extraServiceName, extraServiceUnit, extraServicePrice);

                    // create an House object
                    outputHouse = new House(id, serviceName, usedArea, rentFee, maxPeopleQuantity, rentType,
                            roomStandard, otherUtility, storyNumber, extraService);

                    // add each house object into houseObjectList
                    houseObjectList.add(outputHouse);

                }

                fileReader.close();
                bufferedReader.close();
            }

        } catch (IOException e) {
            System.out.println("Error --> " + e);
        }
        return houseObjectList;
    }

    public static void writeHouseFile(List<House> houseObjectList) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (!houseCsvFile.exists()) {
                fileWriter = new FileWriter(houseCsvFile);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.append(FILE_HEADER);
                bufferedWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter = new FileWriter(houseCsvFile.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);

            if (!houseObjectList.isEmpty()) {
                for (House villa : houseObjectList) {
                    stringBuilder.append(villa.getId());  //1
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(villa.getServiceName());  //2
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(String.valueOf(villa.getUsedArea()));  //3
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(String.valueOf(villa.getRentFee()));  //4
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(String.valueOf(villa.getMaxPeopleQuantity()));  //5
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(villa.getRentType());  //6
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(villa.getRoomStandard());  //7
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(villa.getOtherUtility());  //8
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(String.valueOf(villa.getStoryNumber()));  //9

                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(villa.getExtraService().getExtraServiceName());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(villa.getExtraService().getExtraServiceUnit());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(String.valueOf(villa.getExtraService().getExtraServicePrice()));
                    stringBuilder.append(NEW_LINE_SEPARATOR);
                }
                bufferedWriter.append(stringBuilder);

            } else {
                System.out.println("The list is empty. Please add new House service.");
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
