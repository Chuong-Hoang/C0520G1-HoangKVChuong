package case_study.controllers;

import case_study.models.ExtraService;
import case_study.models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VillaUtils {
    private static List<Villa> villaObjectList = new ArrayList<>();

    // Create file name
    private static final String VILLA_FILE_PATH = "src/case_study/data/Villa.csv";

    // Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    // File header in CSV file
    private static final String FILE_HEADER = "Id, Service Name, Used Area, Rent Amount, Max People Quantity," +
            "Rent Type, Room Standard, Other Utility, Swimming Pool Area, Story Number, " +
            "Extra Service Name, Extra Service Unit, Extra Service Price";

    // Create villa file
    private static File villaCsvFile = new File(VILLA_FILE_PATH);

    public static List<Villa> readVillaFile() {
        try {
            if (!villaCsvFile.exists()) {
                System.out.println("File does not exist.");
            } else {
                FileReader fileReader = new FileReader(villaCsvFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                Villa outputVilla = null;
                String[] villaStringArray;
                String villaString;
                String id;
                String serviceName;
                double usedArea;
                double rentFee;
                int maxPeopleQuantity;
                String rentType;
                String roomStandard;
                String otherUtility;
                double swimmingPoolArea;
                int storyNumber;
                ExtraService extraService;
                String extraServiceName = "N/A";
                String extraServiceUnit = "N/A";
                double extraServicePrice = 0.0;

                //clear villaObjectList for re-writing all objects
                villaObjectList.clear();

                //villaString = bufferedReader.readLine(); // read the FILE_HEADER

                while ((villaString = bufferedReader.readLine()) != null) {
                    //System.out.println(villaString);

                    //change each villaString into array:
                    villaStringArray = villaString.split(",");

                    //get array elements and assign to villa object's attributes
                    id = villaStringArray[0];
                    serviceName = villaStringArray[1];
                    usedArea = Double.parseDouble(villaStringArray[2]);
                    rentFee = Double.parseDouble(villaStringArray[3]);
                    maxPeopleQuantity = Integer.parseInt(villaStringArray[4]);
                    rentType = villaStringArray[5];
                    roomStandard = villaStringArray[6];
                    otherUtility = villaStringArray[7];
                    swimmingPoolArea = Double.parseDouble(villaStringArray[8]);
                    storyNumber = Integer.parseInt(villaStringArray[9]);

                    if (villaStringArray.length > 10) {
                        extraServiceName = villaStringArray[10];
                        extraServiceUnit = villaStringArray[11];
                        extraServicePrice = Double.parseDouble(villaStringArray[12]);
                    }

                    // create an instance of ExtraService class
                    extraService = new ExtraService(extraServiceName, extraServiceUnit, extraServicePrice);

                    // create an Villa object
                    outputVilla = new Villa(id, serviceName, usedArea, rentFee, maxPeopleQuantity, rentType,
                            roomStandard, otherUtility, swimmingPoolArea, storyNumber, extraService);

                    // add each villa object into villaObjectList
                    villaObjectList.add(outputVilla);

                }

                fileReader.close();
                bufferedReader.close();
            }

        } catch (IOException e) {
            System.out.println("Error --> " + e);
        }
        return villaObjectList;
    }

    public static void writeVillaFile(List<Villa> villaObjectList) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (!villaCsvFile.exists()) {
                fileWriter = new FileWriter(villaCsvFile);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.append(FILE_HEADER);
                bufferedWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter = new FileWriter(villaCsvFile.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);

            if (!villaObjectList.isEmpty()) {
                for (Villa villa : villaObjectList) {
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
                    stringBuilder.append(String.valueOf(villa.getSwimmingPoolArea()));  //9
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(String.valueOf(villa.getStoryNumber()));  //10

                    //if (villa.getExtraService() != null) {
                        stringBuilder.append(COMMA_DELIMITER);
                        stringBuilder.append(villa.getExtraService().getExtraServiceName());
                        stringBuilder.append(COMMA_DELIMITER);
                        stringBuilder.append(villa.getExtraService().getExtraServiceUnit());
                        stringBuilder.append(COMMA_DELIMITER);
                        stringBuilder.append(String.valueOf(villa.getExtraService().getExtraServicePrice()));
                   // }
                    stringBuilder.append(NEW_LINE_SEPARATOR);
                }
                bufferedWriter.append(stringBuilder);

            } else {
                System.out.println("The list is empty. Please add new villa service.");
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
