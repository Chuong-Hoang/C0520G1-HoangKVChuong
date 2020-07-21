package demo.file_writer_and_reader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CsvObjectOutput {
    public static void main(String[] args) {
        try {
            //B1: Create stream and link to source
            FileOutputStream fos = new FileOutputStream("/WriteAndRead/CountryOjects.csv");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Define an array:
            Country[] countries = {
                    new Country(111, "US", "United States", "America"),
                    new Country(222, "EN", "England", "Europe"),
                    new Country(333, "SA", "South Africa", "Africa")
            };


            //B2: Write array into file
            oos.writeObject(countries);
            System.out.println("Writing successfully!");

            //B2: close the stream
            fos.close();
            oos.close();
        } catch (IOException e) {
            System.out.println("Error in writing: " + e);
        }
    }
}
