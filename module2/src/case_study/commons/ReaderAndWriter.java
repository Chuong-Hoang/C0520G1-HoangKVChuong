package case_study.commons;
import case_study.controllers.MainController;
import case_study.models.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriter {
    // Delimiter used in CSV files
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    // File header in CSV files
    private static final String VILLA_FILE_HEADER = "Id,Service_Name,Used_Area,Rent_Fee,Max_People,Rent_Type," +
            "Room_Standard,Other_Utility,Swimming_Pool_Area,Story_Number," +
            "Extra_Service_Name,Extra_Service_Unit,Extra_Service_Price";

    private static final String HOUSE_FILE_HEADER = "Id,Service_Name,Used_Area,Rent_Fee,Max_People,Rent_Type," +
            "Room_Standard,Other_Utility,Story_Number," +
            "Extra_Service_Name,Extra_Service_Unit,Extra_Service_Price";

    private static final String ROOM_FILE_HEADER = "Id,Service_Name,Used_Area,Rent_Fee,Max_People,Rent_Type," +
            "Free_Service," +
            "Extra_Service_Name,Extra_Service_Unit,Extra_Service_Price";

    //Read the file
    public static List<Service> readFile(String filePath) {
        List<Service> elementList = new ArrayList<>();
        File csvFile = new File(filePath);
        try {
            if (!csvFile.exists()) {
                throw new FileNotFoundException("File not found.");
            } else {
                //Create a stream and link to source
                FileReader  fileReader = new FileReader(csvFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                /* Read the stream begins here... */
                Villa villa = null;
                House house = null;
                Room room = null;
                Service outputElement = null;

                String[] elementStringArray = null;
                String elementString = null;

                //Common properties
                String a, b, c, d, e, f;

                //Properties for villa and house only
                String vh1, vh2, v3, vh4;

                //Property for room only
                String r1;

                //Properties for Extra Service (Each Service HAS-A)
                ExtraService extraService;
                String e1, e2, e3;

                //Number of private properties
                int privatePropertyNumber = 0;

                //Clear the elementList before adding new objects
                elementList.clear();

                while((elementString = bufferedReader.readLine()) != null) {
                    elementStringArray = elementString.split(",");
                    if ("Id".compareTo(elementStringArray[0]) == 0) {
                        continue;
                    }
                    //Get common properties
                    a = elementStringArray[0];
                    b = elementStringArray[1];
                    c = elementStringArray[2];
                    d = elementStringArray[3];
                    e = elementStringArray[4];
                    f = elementStringArray[5];

                    //Get private properties for each service
                    if (MainController.VILLA_FILE_PATH.compareTo(filePath) == 0) {
                        //VILLA ONLY
                        privatePropertyNumber = 4; // Villa
                        vh1 = elementStringArray[6];
                        vh2 = elementStringArray[7];
                        v3 = elementStringArray[8]; // villa only!!!
                        vh4 = elementStringArray[9];
                        outputElement = new Villa(a,b,c,d,e,f,  vh1,vh2,v3,vh4);

                    } else if (MainController.HOUSE_FILE_PATH.compareTo(filePath) == 0) {
                        //HOUSE ONLY
                        privatePropertyNumber = 3; // House
                        vh1 = elementStringArray[6];
                        vh2 = elementStringArray[7];
                        vh4 = elementStringArray[8];
                        outputElement = new House(a,b,c,d,e,f,  vh1,vh2,vh4);

                    } else if (MainController.ROOM_FILE_PATH.compareTo(filePath) == 0) {
                        //ROOM ONLY
                        privatePropertyNumber = 1; // Room
                        r1 = elementStringArray[6];
                        outputElement = new Room(a,b,c,d,e,f,  r1);
                    }

                    //Get extra service properties
                    e1 = elementStringArray[5 + privatePropertyNumber + 1];
                    e2 = elementStringArray[5 + privatePropertyNumber + 2];
                    e3 = elementStringArray[5 + privatePropertyNumber + 3];
                    extraService = new ExtraService(e1,e2,e3);

                    switch (privatePropertyNumber) {
                        case 4:
                            villa = (Villa) outputElement;
                            villa.setExtraService(extraService);
                            elementList.add(villa);
                            break;
                        case 3:
                            house = (House) outputElement;
                            house.setExtraService(extraService);
                            elementList.add(house);
                            break;
                        case 1:
                            room = (Room) outputElement;
                            room.setExtraService(extraService);
                            elementList.add(room);
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

        return elementList;
    }

    //Write to file
    public static void writeFile(List<Service> elementList, String filePath) {
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
            if (MainController.VILLA_FILE_PATH.compareTo(filePath) == 0) {
                stringBuilder.append(VILLA_FILE_HEADER);
            } else if (MainController.HOUSE_FILE_PATH.compareTo(filePath) == 0) {
                stringBuilder.append(HOUSE_FILE_HEADER);
            } else {
                stringBuilder.append(ROOM_FILE_HEADER);
            }
            stringBuilder.append(NEW_LINE_SEPARATOR);

            if (elementList.isEmpty()) {
                System.out.println("The list is empty.");
            } else {
                for (Service element : elementList) {
                    stringBuilder.append(element.getId());//a
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(element.getServiceName());//b
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(element.getUsedArea());//c
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(element.getRentFee());//d
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(element.getMaxPeopleQuantity());//e
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(element.getRentType());//f
                    stringBuilder.append(COMMA_DELIMITER);

                    if (element instanceof Villa) {
                        stringBuilder.append(((Villa) element).getRoomStandard());//vh1
                        stringBuilder.append(COMMA_DELIMITER);
                        stringBuilder.append(((Villa) element).getOtherUtility());//vh2
                        stringBuilder.append(COMMA_DELIMITER);
                        stringBuilder.append(((Villa) element).getSwimmingPoolArea());//v3
                        stringBuilder.append(COMMA_DELIMITER);
                        stringBuilder.append(((Villa) element).getStoryNumber());//vh4

                    } else if (element instanceof House) {
                        stringBuilder.append(((House) element).getRoomStandard());//vh1
                        stringBuilder.append(COMMA_DELIMITER);
                        stringBuilder.append(((House) element).getOtherUtility());//vh2
                        stringBuilder.append(COMMA_DELIMITER);
                        stringBuilder.append(((House) element).getStoryNumber());//vh4

                    } else {
                        stringBuilder.append(((Room) element).getFreeService());//r1
                    }

                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(element.getExtraService().getExtraServiceName());//e1
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(element.getExtraService().getExtraServiceUnit());//e2
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(element.getExtraService().getExtraServicePrice());//e3
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
