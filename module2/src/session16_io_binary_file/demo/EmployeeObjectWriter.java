package session16_io_binary_file.demo;

import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class EmployeeObjectWriter {
    public static List<Employee> employeeList = new ArrayList<>();
    public static void main(String[] args) {
        File file = new File("src/session16_io_binary_file/demo/Employee.txt");
        readEmployeeObject(file);
        writeEmployeeObject(file);
        readEmployeeObject(file);
    }

    public static void writeEmployeeObject(File file) {
        Scanner sc = new Scanner(System.in);
        try {

            //Step 1: create a stream and link to source
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            //Step 2: Input employee from keyboard and write to file
            System.out.print("Input name: ");
            String name = sc.nextLine();

            System.out.print("Input id: ");
            int id = sc.nextInt();

            System.out.print("Input age: ");
            int age = sc.nextInt();

            System.out.print("Input salary: ");
            int salary = sc.nextInt();

            Employee em = new Employee(name, id, age, salary);
            employeeList.add(em);
            objectOutputStream.writeObject(employeeList);

            //Step 3: Close the stream
            fileOutputStream.flush();
            fileOutputStream.close();
            objectOutputStream.close();
            System.out.println("Writing employee object successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e);
    }
}

    public static void readEmployeeObject(File file) {
        try {
            if (!file.exists()) {
                throw new FileNotFoundException("File does not exist.");
            } else {
                //Step 1: Create a stream and link to source
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                //Step 2: Read the stream

                employeeList = (List<Employee>) objectInputStream.readObject();
                for (Employee e : employeeList) {
                    System.out.println(e);
                }

                //Step 3: Close the stream
                fileInputStream.close();
                objectInputStream.close();

            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e);
        }
    }
}
