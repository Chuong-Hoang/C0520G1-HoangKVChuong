package demo.file_writer_and_reader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;

public class CsvWriter {
    // Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    // CSV file header
    private static final String FILE_HEADER = "id, code, name, continent";

    // Create file name
    private static final String FILE_NAME = "/WriteAndRead/Countries.csv";

    // Main() method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a countryList to store country objects
        List<Country> countryList = new ArrayList<>();

        FileWriter fw = null;
        BufferedWriter bw = null;
        File file = new File(FILE_NAME);
        try {
            // if file doesn't exist, then create file
            if (!file.exists()) {
                file.createNewFile();
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);

                // Write CSV file header
                bw.append(FILE_HEADER);

                // Add new line separator
                bw.append(NEW_LINE_SEPARATOR);
            }

            // true, append file
            fw = new FileWriter(file.getAbsoluteFile(), true);

        } catch (Exception e) {
            System.out.println("Error in CsvWriter");
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                System.out.println("Error in closing in FileWriter");
                e.printStackTrace();
            }
        }

        System.out.print("How many countries do you want to add? ");
        int number = sc.nextInt();

        // Write country objects from countryList into CSV file
        for (int i = 1; i <= number; i++) {
            writeCsvFile(file, countryList);
        }
    }

    public static void writeCsvFile(File file, List<Country> list) {
        Scanner sc = new Scanner(System.in);
        // Create new country objects
        System.out.print("Input country id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Input country code: ");
        String code = sc.nextLine();

        System.out.print("Input country name: ");
        String name = sc.nextLine();

        System.out.print("Input continent of the country: ");
        String continent = sc.nextLine();

        Country newCountry = new Country(id, code, name, continent);

        // Add country objects into the list
        list.add(newCountry);

        FileWriter fileWriter = null;


        try {

            // if file doesn't exist, then create file
            if (!file.exists()) {
                file.createNewFile();
            }

            // true, append file
            fileWriter = new FileWriter(file.getAbsoluteFile(), true);

            // Write a new Country object list to the CSV file
            for (Country country : list) {
                fileWriter.append(String.valueOf(country.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(country.getCode());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(country.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(country.getContinent());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("CSV file was created successfully at... /WriteAndRead/");

        } catch (Exception e) {
            System.out.println("Error in CsvFieWriter!");
            e.printStackTrace();
        } finally {
             try {
                 fileWriter.flush();
                 fileWriter.close();
             } catch (IOException e) {
                 System.out.println("Error while flushing/closing fileWriter!");
             }
        }
    }
}
