package examination;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {
    private static final String FILE_PATH = "src/examination/Product.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //Create file
    static File csvFile = new File(FILE_PATH);

    //Read the file
    public static List<Product> readFile() {
        List<Product> elementList = new ArrayList<>();

        try {
            if (!csvFile.exists()) {
                throw new FileNotFoundException("File does not exist.");
            } else {
                //Create a stream and link to source
                FileReader fileReader = new FileReader(csvFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                /* Read the stream begins here... */
                int id;
                String a,b,c,d,e,  i1,i2,i3,   e1,e2;

                String outputString;
                String[] outputStringArray;

                while ((outputString = bufferedReader.readLine()) != null) {
                    outputStringArray = outputString.split(",");

                    if(outputStringArray.length > 1) {

                        id = Integer.parseInt(outputStringArray[0]);  //***********
                        a = outputStringArray[1];
                        b = outputStringArray[2];
                        c = outputStringArray[3];
                        d = outputStringArray[4];
                        e = outputStringArray[5];

                        if (outputStringArray.length > 8) {

                            i1 = outputStringArray[6];
                            i2 = outputStringArray[7];
                            i3 = outputStringArray[8];

                            Product outputElement = new ImportProduct(a,b,c,d,e, i1,i2,i3);

                            //.....................
                            outputElement.setId(id); //***********
                            elementList.add(outputElement);
                        } else {

                            e1 = outputStringArray[6];
                            e2 = outputStringArray[7];

                            Product outputElement = new ExportProduct(a,b,c,d,e, e1,e2);

                            //...................
                            outputElement.setId(id); //************
                            elementList.add(outputElement);
                        }
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

    public static void writeFile(List<Product> elementList) {
        try {
            FileWriter fileWriter = new FileWriter(csvFile.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();

            if (elementList.isEmpty()) {
                System.out.println("The list is empty. Please add new object...");
            } else {

                for (Product element : elementList) {

                    stringBuilder.append(element.getId());//must setId()

                    stringBuilder.append(COMMA_DELIMITER);

                    stringBuilder.append(element.getCode()); //a

                    stringBuilder.append(COMMA_DELIMITER);

                    stringBuilder.append(element.getName()); //b

                    stringBuilder.append(COMMA_DELIMITER);

                    stringBuilder.append(element.getPrice());//c

                    stringBuilder.append(COMMA_DELIMITER);

                    stringBuilder.append(element.getQuantity());//d

                    stringBuilder.append(COMMA_DELIMITER);

                    stringBuilder.append(element.getProvider());//e

                    stringBuilder.append(COMMA_DELIMITER);

                    if (element instanceof ImportProduct) {

                        stringBuilder.append(((ImportProduct) element).getImportPrice());//i1

                        stringBuilder.append(COMMA_DELIMITER);

                        stringBuilder.append(((ImportProduct) element).getImportProvince());//i2

                        stringBuilder.append(COMMA_DELIMITER);

                        stringBuilder.append(((ImportProduct) element).getImportTax());//i3

                    } else if (element instanceof ExportProduct) {

                        stringBuilder.append(((ExportProduct) element).getExportPrice());//e1

                        stringBuilder.append(COMMA_DELIMITER);

                        stringBuilder.append(((ExportProduct) element).getBuyingCountry());//e2
                    }
                    stringBuilder.append(NEW_LINE_SEPARATOR);

                }

                bufferedWriter.append(stringBuilder);

                fileWriter.flush();
                bufferedWriter.flush();
                fileWriter.close();
                bufferedWriter.close();
            }
        } catch (IOException e) {
            System.out.println(e);;
        }

    }

}

