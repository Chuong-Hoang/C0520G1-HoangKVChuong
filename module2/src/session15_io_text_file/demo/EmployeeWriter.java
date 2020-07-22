package session15_io_text_file.demo;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class EmployeeWriter {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        File file = new File("src/session15_io_text_file/demo/employees.txt");
        System.out.println("How many employees to be added? ");
        int number = sc.nextInt();
        for (int i = 1; i <= number; i++) {
            writeEmployee(file);
        }
        readEmployee(file);

    }

    public static void writeEmployee(File file) {
        Scanner sc = new Scanner(System.in);
        try {
            //Step 1: Create a stream and link to source
            FileWriter fileWriter = new FileWriter(file, true);

            //Step 2: Input from keyboard and write to file
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuffer stringBuffer = new StringBuffer();
            System.out.print("Input name: ");
            String name = sc.nextLine();
            System.out.print("Input id: ");
            int id = sc.nextInt();
            System.out.print("Input age: ");
            int age = sc.nextInt();
            System.out.print("Input salary: ");
            int salary = sc.nextInt();
            stringBuffer.append(new Employee(name, id, age, salary));
            stringBuffer.append("\n");

            bufferedWriter.write(String.valueOf(stringBuffer));
            System.out.println("Writing successfully!");

            //Step 3: Close the stream
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public static void readEmployee(File file) {
        try {
            if(!file.exists()) {
                throw new FileNotFoundException("File does not exits.");
            } else {
                //step 1: create a stream and link to source
                FileReader fileReader = new FileReader(file);

                //step 2: read the file
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;

                while((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }

                //step 3: close the stream
                bufferedReader.close();
                fileReader.close();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
