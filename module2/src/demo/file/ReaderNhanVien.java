package demo.file;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReaderNhanVien {
    public static void main(String[] args) {
        try {
            //B1: create stream and link to source
            File f = new File("/WriteAndRead/nhanvien.txt");
            FileReader fr = new FileReader(f);

            //B2: read the stream
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            //B3: close the stream
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Error in reading: " + e);
        } finally {
            System.out.println("Reading file ends here.");
        }
    }
}
