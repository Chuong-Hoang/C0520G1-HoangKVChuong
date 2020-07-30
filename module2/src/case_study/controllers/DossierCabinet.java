package case_study.controllers;
import case_study.controllers.EmployeeUtils;
import case_study.models.Employee;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class DossierCabinet {
    private Stack<Employee> employeeStackList;

    public DossierCabinet() {
        employeeStackList = new Stack<>();
    }

    public DossierCabinet(Stack<Employee> employeeList) {
        this.employeeStackList = employeeList;
    }

    public Stack<Employee> getEmployeeStackList() {
        return employeeStackList;
    }

    public void setEmployeeStackList(Stack<Employee> employeeStackList) {
        this.employeeStackList = employeeStackList;
    }

    //Manipulators
    public Stack<Employee> createDossierCabinet() {

        //Get employeeObjectList <Map>
        Map<String, Employee> employeeObjectList = EmployeeUtils.readEmployeeFile();

        //Add employees from map into DossierCabinet <Stack>
        System.out.println("Adding employee profiles to DossierCabinet");
        System.out.println(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .");
        Set<String> employeeIds = employeeObjectList.keySet();
        int i = 1;
        for (String employeeId : employeeIds) {
            Employee employee = employeeObjectList.get(employeeId);
            employeeStackList.push(employee);

            //Display each employee when adding to stack
            System.out.print("Adding no." + i + ": => ");
            employee.toString();
            i++;
        }
        System.out.println("*** Adding finished......................................................................");
        System.out.println();

        return employeeStackList;
    }

    public void findEmployeeDossier() {
        Scanner sc = new Scanner(System.in);
        Stack<Employee> tempDossierStack = new Stack<>();

        System.out.println("NEW EMPLOYEE DOSSIER-CABINET:");
        System.out.println("[************************  BOTTOM to TOP of Dossier-Cabinet  ************************]");
        System.out.println("BOTTOM begins here...");
        System.out.printf("%-5s%-20s%-25s%-20s%s\n", "No.", "Employee_Id", "Employee_Name","Employee_Age",
                "Employee_Address");
        int i = 1;
        for (Employee employee : this.employeeStackList) {
            System.out.printf("%-5s", i + ". ");
            employee.toString();
            i++;
        }
        System.out.println("TOP ends here.");
        System.out.println("[_______________________________TOP of Dossier-Cabinet_______________________________]");

        System.out.print("=> Input employee Id to be searched: ");
        String employeeId = sc.nextLine();
        Employee takenEmployee;
        Employee seekedEmployee = null;
        boolean isFound = false;
        while (!employeeStackList.isEmpty()) {
            takenEmployee = employeeStackList.pop();
            if (employeeId.compareTo(takenEmployee.getId()) == 0){
                System.out.println("--> Employee Id " + employeeId + " found:");
                System.out.println("_________________________________________________________________________________");
                System.out.printf("%-20s%-25s%-20s%s\n", "Employee_Id", "Employee_Name","Employee_Age",
                        "Employee_Address");
                takenEmployee.toString();
                System.out.println("_________________________________________________________________________________");
                seekedEmployee = takenEmployee;
                isFound = true;
                break;
            } else {
                tempDossierStack.push(takenEmployee);
            }
        }
        employeeStackList.addAll(tempDossierStack);
        if (isFound) {
            employeeStackList.push(seekedEmployee);
        } else {
            System.out.println("--> Employee Id " + employeeId + " not found in the dossier-cabinet.");
        }

        System.out.println();
        System.out.println("EMPLOYEE DOSSIER-CABINET AFTER FINDING COMPLETELY:");

        System.out.println("[****************************** Employee Dossier-Cabinet *******************************]");
        System.out.println("From TOP...");
        System.out.printf("%-5s%-20s%-25s%-20s%s\n", "No.", "Employee_Id", "Employee_Name","Employee_Age",
                "Employee_Address");
        Employee employee;
        i = 1;
        while (!employeeStackList.isEmpty()) {
            employee = this.employeeStackList.pop();
            System.out.printf("%-5s", i + ". ");
            employee.toString();
            i++;
        }
        System.out.println("...to BOTTOM.");
        System.out.println("[_______________________________Bottom of Dossier-Cabinet_______________________________]");
    }
}
