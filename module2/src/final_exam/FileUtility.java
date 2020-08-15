package final_exam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {
    private static final String FILE_PATH = "src/final_exam/Contact.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //Create file
    static File csvFile = new File(FILE_PATH);

    //Read the file
    public static List<Contact> readFile() {
        List<Contact> elementList = new ArrayList<>();

        try {
            if (!csvFile.exists()) {
                throw new FileNotFoundException("File does not exist.");
            } else {
                //Create a stream and link to source
                FileReader fileReader = new FileReader(csvFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                /* Read the stream begins here... */
                int id;
                String a, b, c, d, e, e1, e2;

                String outputString;
                String[] outputStringArray;
                Contact outputElement = null;

                while ((outputString = bufferedReader.readLine()) != null) {
                    outputStringArray = outputString.split(",");

                    if (outputStringArray.length > 1) {
                        a = outputStringArray[0];
                        b = outputStringArray[1];
                        c = outputStringArray[2];
                        d = outputStringArray[3];
                        e = outputStringArray[4];
                        e1 = outputStringArray[5];
                        e2 = outputStringArray[6];

                        outputElement = new Contact(a, b, c, d, e, e1, e2);

                        elementList.add(outputElement);
                    }
                }

                //Close the stream
                fileReader.close();
                bufferedReader.close();
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
        return elementList;
    }

    public static void writeFile(List<Contact> elementList) {
        try {
            //Create a stream
            FileWriter fileWriter = new FileWriter(csvFile.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();

            if (elementList.isEmpty()) {
                System.out.println("The list is empty. Please add new object...");
            } else {

                //write to the stream
                for (Contact element : elementList) {

                    stringBuilder.append(element.getPhoneNumber());//a

                    stringBuilder.append(COMMA_DELIMITER);

                    stringBuilder.append(element.getGroup()); //b

                    stringBuilder.append(COMMA_DELIMITER);

                    stringBuilder.append(element.getFullName()); //c

                    stringBuilder.append(COMMA_DELIMITER);

                    stringBuilder.append(element.getGender());//d

                    stringBuilder.append(COMMA_DELIMITER);

                    stringBuilder.append(element.getAddress());//e

                    stringBuilder.append(COMMA_DELIMITER);

                    stringBuilder.append(element.getBirthday());//e1

                    stringBuilder.append(COMMA_DELIMITER);

                    stringBuilder.append(element.getEmail());//e2

                    stringBuilder.append(NEW_LINE_SEPARATOR);
                }

                bufferedWriter.append(stringBuilder);

                //Close the stream
                fileWriter.flush();
                bufferedWriter.flush();
                fileWriter.close();
                bufferedWriter.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}

