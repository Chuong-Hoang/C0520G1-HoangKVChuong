package session15_io_text_file.demo;
import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class EmployeeObjectWriter {
    public static void main(String[] args) {
        File file = new File("src/session15_io_text_file/demo/employeeObject.txt");
        writeEmployeeObject(file);
        readEmployeeObject(file);
    }

    public static void writeEmployeeObject(File file) {
        Scanner sc = new Scanner(System.in);
        try {
            //Step 1: create a stream and link to source
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            //Step 2: Input employee from keyboard and write to file
            List<Employee> employeesList = new ArrayList<>();
            System.out.print("How many employees to be added? ");
            int number = sc.nextInt();
            sc.nextLine();
            for (int i = 1; i <= number; i++) {
                System.out.print("Input name: ");
                String name = sc.nextLine();

                System.out.print("Input id: ");
                int id = sc.nextInt();

                System.out.print("Input age: ");
                int age = sc.nextInt();

                System.out.print("Input salary: ");
                int salary = sc.nextInt();
                sc.nextLine();

                employeesList.add(new Employee(name, id, age, salary));
            }

            objectOutputStream.writeObject(employeesList);
            System.out.println("Writing employee objects successfully!");

            //Step 3: Close the stream
            fileOutputStream.close();
            objectOutputStream.close();

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
                List<Employee> employees = (ArrayList<Employee>) objectInputStream.readObject();

                for (Employee e : employees) {
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
