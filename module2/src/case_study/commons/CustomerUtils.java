package case_study.commons;
import case_study.models.Customer;
import case_study.models.Service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerUtils {
    private static List<Customer> customerObjectList = new ArrayList<>();
    private static final String CUSTOMER_FILE_PATH = "src/case_study/data/Customer.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static File customerCsvFile = new File(CUSTOMER_FILE_PATH);

    public static List<Customer> readCustomerFile() {

        if (!customerCsvFile.exists()) {
            System.out.println("File does not exist.");
        } else if(customerCsvFile.toString() == null) {
            System.out.println("File exists but it has no data at all.");
        } else {
            try {
                //Create a stream and link to source
                FileReader fileReader = new FileReader(customerCsvFile);
                BufferedReader  bufferedReader = new BufferedReader(fileReader);

                //Create an array to store data read by bufferedReader
                String[] customerStringArray;
                String line;
                String name;
                String birthday;
                String gender;
                String idNumber;
                String phoneNumber;
                String email;
                String customerType;
                String address;
                Service service;
                Customer outputCustomer = null;

                //Clear customerObjectList before adding new Customer objects
                customerObjectList.clear();

                while ((line = bufferedReader.readLine()) != null) {
                    customerStringArray = line.split(",");
                    name = customerStringArray[0];
                    birthday = customerStringArray[1];
                    gender = customerStringArray[2];
                    idNumber = customerStringArray[3];
                    phoneNumber = customerStringArray[4];
                    email = customerStringArray[5];
                    customerType = customerStringArray[6];
                    address = customerStringArray[7];

                    //change string data into Customer object
                    outputCustomer = new Customer(name, birthday, gender, idNumber, phoneNumber,
                            email, customerType, address);

                    //add Customer object into ArrayList
                    customerObjectList.add(outputCustomer);
                }

                //close the stream
                fileReader.close();
                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return customerObjectList;
    }

    public static void writeCustomerFile(List<Customer> customerObjectList) {
        try {
            if(!customerCsvFile.exists()) {
                customerCsvFile.createNewFile();
            }
            //Create a stream and link to source
            FileWriter fileWriter = new FileWriter(customerCsvFile.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();

            //Write each Customer object
            if (!customerObjectList.isEmpty()) {
                for (Customer customer : customerObjectList) {
                    stringBuilder.append(customer.getName());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(customer.getBirthday());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(customer.getGender());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(customer.getIdNumber());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(customer.getPhoneNumber());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(customer.getEmail());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(customer.getCustomerType());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(customer.getAddress());
                    //stringBuilder.append(COMMA_DELIMITER);
                    //stringBuilder.append(customer.getServices());
                    stringBuilder.append(NEW_LINE_SEPARATOR);
                }
                //Write stringBuilder into customer list
                bufferedWriter.append(stringBuilder);
            }

            //Close the stream
            fileWriter.flush();
            bufferedWriter.flush();
            fileWriter.close();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
