package session15_io_text_file.homeworks;
import java.io.*;
import java.util.Scanner;

public class ReadCsvFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("src/session15_io_text_file/homeworks/Country.csv");
        System.out.print("How many countries to be added? ");
        int number = sc.nextInt();
        for (int i = 1; i <= number; i++) {
            writeCsvFile(file);
            readCsvFile(file);
        }


    }

    public static void writeCsvFile(File file) {
        Scanner sc = new Scanner(System.in);
        try {
            //B1: Create a stream and link to source
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //B2: Write to file
            StringBuffer stringBuffer = new StringBuffer();
            System.out.print("Input code1: ");
            String code1 = sc.nextLine();
            stringBuffer.append(code1).append(",");

            System.out.print("Input code2: ");
            String code2 = sc.nextLine();
            stringBuffer.append(code2).append(",");

            System.out.print("Input code3: ");
            String code3 = sc.nextLine();
            stringBuffer.append(code3).append(",");

            System.out.print("Input code4: ");
            String code4 = sc.nextLine();
            stringBuffer.append(code4).append(",");

            System.out.print("Input code5: ");
            String code5 = sc.nextLine();
            stringBuffer.append(code5).append(",");

            System.out.print("Input name: ");
            String name = sc.nextLine();
            stringBuffer.append(name).append("\n");

            bufferedWriter.write(String.valueOf(stringBuffer));
            System.out.println("Writing file completely!");

            //B2: Close the stream
            bufferedWriter.close();;
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Error in writing: " + e);
        }
    }

    public static void readCsvFile(File file) {
        if(!file.exists()) {
            System.out.println("File does not exist...");
        } else {
            try {
                //B1: Create a stream and link to source
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                //B2: Read the file
                StringBuffer stringBuffer = new StringBuffer();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line);
                    stringBuffer.append("\n");
                }
                System.out.println(stringBuffer);

                //B3: close the stream
                bufferedReader.close();
                fileReader.close();

            } catch (IOException e) {
                System.out.println("Error in reading: " + e);
            }
        }
    }
}
