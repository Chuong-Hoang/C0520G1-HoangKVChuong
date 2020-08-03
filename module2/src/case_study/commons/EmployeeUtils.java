package case_study.commons;

import case_study.models.Employee;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeUtils {
    private static Map<String, Employee> employeeMapList = new TreeMap<>();
    private final static String EMPLOYEE_FILE_PATH = "src/case_study/data/Employee.csv";

    public static Map<String, Employee> readEmployeeFile() {
        File file = new File(EMPLOYEE_FILE_PATH);
        if (!file.exists()) {
            System.out.println("The employees list does not exist.");
        } else {
            try {
                //create a reader stream and link to source
                FileReader fileReader = new FileReader(file.getAbsoluteFile());
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String[] employeeStringArray;
                Employee outputEmployee;
                String employeeId;
                String name;
                int age;
                String address;

                //Read the file header;
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    employeeStringArray = line.split(",");
                    if ("Employee_Id".compareTo(employeeStringArray[0]) == 0) {
                        continue;
                    }
                    employeeId = employeeStringArray[0];
                    name = employeeStringArray[1];
                    age = Integer.parseInt(employeeStringArray[2]);
                    address = employeeStringArray[3];

                    //Create employee Object and add to map
                    outputEmployee = new Employee(employeeId, name, age, address);
                    employeeMapList.put(employeeId, outputEmployee);
                }

                //close the stream
                fileReader.close();
                bufferedReader.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return employeeMapList;
    }
}
