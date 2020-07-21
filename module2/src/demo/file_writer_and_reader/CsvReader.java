package demo.file_writer_and_reader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class CsvReader {
    public static void main(String[] args) {

        try {
            // B1: Create stream and link to source
            File f = new File("/WriteAndRead/Countries.csv");
            FileReader fr = new FileReader(f);

            // B2: Read data
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // B2: close stream
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println("Error in CsvReader: " + e);
        }
    }
}