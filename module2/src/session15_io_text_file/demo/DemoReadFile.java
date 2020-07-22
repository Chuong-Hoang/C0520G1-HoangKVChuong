package session15_io_text_file.demo;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DemoReadFile {
    public static void main(String[] args) {
        File f = new File("/Demo2/myFile1.txt");

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null) {
                System.out.println("Line is: " + line);
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error in reading file: " + e);
        }
    }
}
