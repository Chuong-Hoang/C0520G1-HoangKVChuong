package demo.file_writer_and_reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class CsvObjectInput {
    public static void main(String[] args) {
        try {
            //B1: Create stream and link to source
            FileInputStream fis = new FileInputStream("/WriteAndRead/CountryOjects.csv");
            ObjectInputStream ois = new ObjectInputStream(fis);

            //B2: Read the data stream
            Country[] list = (Country[]) ois.readObject();

            for (Country c : list) {
                System.out.println(c.toString());
            }

            //B3: Close the stream
            fis.close();
            ois.close();
        } catch (Exception e) {
            System.out.println("Error in reading file:" + e);
        }
    }
}
