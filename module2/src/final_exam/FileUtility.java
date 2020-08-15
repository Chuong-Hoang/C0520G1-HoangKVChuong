package final_exam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {

    //Create file
    static File csvFile = new File(Constant.FILE_PATH);

    //Read the file
    public static List<Contact> readFile() {
        List<Contact> elementList = new ArrayList<>();

        try {
            if (!csvFile.exists()) {
                throw new FileNotFoundException(Constant.FILE_NOT_FOUND);
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
                    outputStringArray = outputString.split(Constant.COMMA);

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
                System.out.println(Constant.LIST_IS_EMPTY);
            } else {

                //write to the stream
                for (Contact element : elementList) {
                    stringBuilder.append(element.getPhoneNumber());//a
                    stringBuilder.append(Constant.COMMA);
                    stringBuilder.append(element.getGroup()); //b
                    stringBuilder.append(Constant.COMMA);
                    stringBuilder.append(element.getFullName()); //c
                    stringBuilder.append(Constant.COMMA);
                    stringBuilder.append(element.getGender());//d
                    stringBuilder.append(Constant.COMMA);
                    stringBuilder.append(element.getAddress());//e
                    stringBuilder.append(Constant.COMMA);
                    stringBuilder.append(element.getBirthday());//e1
                    stringBuilder.append(Constant.COMMA);
                    stringBuilder.append(element.getEmail());//e2
                    stringBuilder.append(Constant.NEW_LINE);
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

