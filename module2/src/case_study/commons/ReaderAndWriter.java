package case_study.commons;
import case_study.models.*;
import demo.class_and_object.Arr;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriter {
    private static List<Services> serviceObjectList = new ArrayList<>();

    // Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    // File header in CSV file
    private static final String VILLA_FILE_HEADER = "Id,Service Name,Used Area,Rent Fee,Max People,Rent Type," +
            "Room Standard,Other Utility,Swimming Pool Area,Story Number," +
            "Extra Service Name,Extra Service Unit,Extra Service Price";

    private static final String HOUSE_FILE_HEADER = "Id,Service Name,Used Area,Rent Fee,Max People,Rent Type," +
            "Room Standard,Other Utility,Story Number," +
            "Extra Service Name,Extra Service Unit,Extra Service Price";

    private static final String ROOM_FILE_HEADER = "Id,Service Name,Used Area,Rent Fee,Max People,Rent Type," +
            "Free Service," +
            "Extra Service Name,Extra Service Unit,Extra Service Price";

    //Read the file;
    public static List<? extends Services> readServiceFile(String filePath) {
        File csvFile = new File(filePath);
        try {
            if (!csvFile.exists()) {
                throw new FileNotFoundException("File not found.");
            } else {
                //Create a stream and link to source
                FileReader  fileReader = new FileReader(csvFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                //Read the stream
                Villa outputVilla = null;
                House outputHouse = null;
                Room outputRoom = null;
                Object outputObject = null;

                String[] serviceStringArray;
                String serviceString;

                //Common properties
                String id;
                String serviceName;
                double usedArea;
                double rentFee;
                int maxPeopleQuantity;
                String rentType;

                //Properties for villa and house only
                String roomStandard;
                String otherUtility;
                double swimmingPoolArea; // villa only!!!
                int storyNumber;

                //Property for room only
                String freeService;

                //Properties for Extra Service (Each Service HAS-A)
                ExtraService extraService;
                String extraServiceName = "N/A";
                String extraServiceUnit = "N/A";
                double extraServicePrice = 0.0;

                //Number of private properties
                int privatePropertyNumber = 0;

                //Clear the serviceObjectList before adding new objects
                serviceObjectList.clear();

                while((serviceString = bufferedReader.readLine()) != null) {
                    serviceStringArray = serviceString.split(",");
                    if ("Id".compareTo(serviceStringArray[0]) == 0) {
                        continue;
                    }
                    //Get common properties
                    id = serviceStringArray[0];
                    serviceName = serviceStringArray[1];
                    usedArea = Double.parseDouble(serviceStringArray[2]);
                    rentFee = Double.parseDouble(serviceStringArray[3]);
                    maxPeopleQuantity = Integer.parseInt(serviceStringArray[4]);
                    rentType = serviceStringArray[5];

                    //Get private properties for each service
                    if ("src/case_study/data/Villa.csv".equals(filePath)) {
                        privatePropertyNumber = 4; // Villa
                        roomStandard = serviceStringArray[6];
                        otherUtility = serviceStringArray[7];
                        swimmingPoolArea = Double.parseDouble(serviceStringArray[8]); // villa only!!!
                        storyNumber = Integer.parseInt(serviceStringArray[9]);
                        outputObject = new Villa(id, serviceName, usedArea, rentFee, maxPeopleQuantity, rentType,
                                roomStandard, otherUtility, swimmingPoolArea, storyNumber);
                    } else if ("src/case_study/data/House.csv".equals(filePath)) {
                        privatePropertyNumber = 3; // House
                        roomStandard = serviceStringArray[6];
                        otherUtility = serviceStringArray[7];
                        storyNumber = Integer.parseInt(serviceStringArray[8]);
                        outputObject = new House(id, serviceName, usedArea, rentFee, maxPeopleQuantity, rentType,
                                roomStandard, otherUtility, storyNumber);
                    } else if ("src/case_study/data/Room.csv".equals(filePath)) {
                        privatePropertyNumber = 1; // Room
                        freeService = serviceStringArray[6];
                        outputObject = new Room(id, serviceName, usedArea, rentFee, maxPeopleQuantity, rentType,
                                freeService);
                    }

                    //Get extra service properties
                    extraServiceName = serviceStringArray[5 + privatePropertyNumber + 1];
                    extraServiceUnit = serviceStringArray[5 + privatePropertyNumber + 2];
                    extraServicePrice = Double.parseDouble(serviceStringArray[5 + privatePropertyNumber + 3]);
                    extraService = new ExtraService(extraServiceName, extraServiceUnit, extraServicePrice);

                    switch (privatePropertyNumber) {
                        case 4:
                            outputVilla = (Villa) outputObject;
                            outputVilla.setExtraService(extraService);
                            serviceObjectList.add(outputVilla);
                            break;
                        case 3:
                            outputHouse = (House) outputObject;
                            outputHouse.setExtraService(extraService);
                            serviceObjectList.add(outputHouse);
                            break;
                        case 1:
                            outputRoom = (Room) outputObject;
                            outputRoom.setExtraService(extraService);
                            serviceObjectList.add(outputRoom);
                            break;
                        default:
                            System.out.println("Error...");
                    }
                }

                //Close the stream
                fileReader.close();
                bufferedReader.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return serviceObjectList;
    }

    //Write to file
    public static void writeServiceFile(List<? extends Services> serviceObjectList, String filePath) {
        File csvFile = new File(filePath);
        try {
            if (!csvFile.exists()) {
                throw new FileNotFoundException("File does not exist.");
            }
            //Create a stream and link to source
            FileWriter fileWriter = new FileWriter(csvFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();

            //Write to stream
            if ("src/case_study/data/Villa.csv".compareTo(filePath) == 0) {
                stringBuilder.append(VILLA_FILE_HEADER);
            } else if ("src/case_study/data/House.csv".compareTo(filePath) == 0) {
                stringBuilder.append(HOUSE_FILE_HEADER);
            } else {
                stringBuilder.append(ROOM_FILE_HEADER);
            }
            stringBuilder.append(NEW_LINE_SEPARATOR);

            if (serviceObjectList.isEmpty()) {
                System.out.println("The list is empty.");
            } else {
                for (Services service : serviceObjectList) {
                    stringBuilder.append(service.getId());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(service.getServiceName());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(service.getUsedArea());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(service.getRentFee());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(service.getMaxPeopleQuantity());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(service.getRentType());
                    stringBuilder.append(COMMA_DELIMITER);

                    if (service instanceof Villa) {
                        stringBuilder.append(((Villa) service).getRoomStandard());
                        stringBuilder.append(COMMA_DELIMITER);
                        stringBuilder.append(((Villa) service).getOtherUtility());
                        stringBuilder.append(COMMA_DELIMITER);
                        stringBuilder.append(((Villa) service).getSwimmingPoolArea());
                        stringBuilder.append(COMMA_DELIMITER);
                        stringBuilder.append(((Villa) service).getStoryNumber());

                    } else if (service instanceof House) {
                        stringBuilder.append(((House) service).getRoomStandard());
                        stringBuilder.append(COMMA_DELIMITER);
                        stringBuilder.append(((House) service).getOtherUtility());
                        stringBuilder.append(COMMA_DELIMITER);
                        stringBuilder.append(((House) service).getStoryNumber());

                    } else {
                        stringBuilder.append(((Room) service).getFreeService());
                    }

                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(service.getExtraService().getExtraServiceName());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(service.getExtraService().getExtraServiceUnit());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(service.getExtraService().getExtraServicePrice());
                    stringBuilder.append(NEW_LINE_SEPARATOR);
                }
            }

            bufferedWriter.append(stringBuilder);

            //Close the stream
            fileWriter.flush();
            bufferedWriter.flush();
            fileWriter.close();
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
