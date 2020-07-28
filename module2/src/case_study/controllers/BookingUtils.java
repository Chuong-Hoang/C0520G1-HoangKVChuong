package case_study.controllers;
import case_study.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BookingUtils {
    private static final String BOOKING_PATH_FILE = "src/case_study/data/Booking.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String SPACE_DELIMITER = " ";
    private static List<Customer> bookingList = new ArrayList<>();

    //Create a bookingCsvFile
    static File bookingCsvFile = new File(BOOKING_PATH_FILE);

    public static List<Customer> readBookingFile() {
        bookingList.clear();
        if(!bookingCsvFile.exists()) {
            System.out.println("The booking list is empty...");
        } else {
            try {
                FileReader fileReader = new FileReader(bookingCsvFile.getAbsoluteFile());
                BufferedReader bufferedReader = new BufferedReader(fileReader);

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
                Object serviceObject;
                String serviceId;
                String serviceName;
                Customer outputCustomer = null;

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
                    serviceId = customerStringArray[8];
                    serviceName = customerStringArray[9];

                    //change string data into Customer (booking) object
                    if (serviceId.contains("SVVL")) {
                        serviceObject = new Villa(serviceId, serviceName);
                    } else if (serviceId.contains("SVHO")) {
                        serviceObject = new House(serviceId, serviceName);
                    } else {
                        serviceObject = new Room(serviceId, serviceName);
                    }
                    outputCustomer = new Customer(name, birthday, gender, idNumber, phoneNumber,
                            email, customerType, address, (Services) serviceObject);

                    bookingList.add(outputCustomer);
                }

                fileReader.close();
                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return bookingList;
    }

    public static void writeBookingFile(List<Customer> bookingList) {
        try {
            if (!bookingCsvFile.exists()) {
                bookingCsvFile.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(bookingCsvFile.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();

            //Write customer (booking) object into file
            for (Customer customer : bookingList) {
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
                stringBuilder.append(COMMA_DELIMITER);
                stringBuilder.append(customer.getServices().getId());
                stringBuilder.append(COMMA_DELIMITER);
                stringBuilder.append(customer.getServices().getServiceName());
                stringBuilder.append(NEW_LINE_SEPARATOR);
            }
            bufferedWriter.append(stringBuilder);

            fileWriter.flush();
            bufferedWriter.flush();
            fileWriter.close();
            bufferedWriter.close();

        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
