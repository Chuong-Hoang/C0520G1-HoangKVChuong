package session15_io_text_file.demo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class DemoWriteFile {
    public static void main(String[] args) {
        File dir = new File("/Demo2");
        dir.mkdir();
        File f1 = new File("/Demo2/myFile1.txt");

        try {
            // B1: Create a stream and link to source
            if(!f1.exists()) {
                f1.createNewFile();
            }

            FileWriter fw1 = new FileWriter(f1.getAbsoluteFile(), true);
            BufferedWriter bw1 = new BufferedWriter(fw1);

            // B2: Write to file
            bw1.write("This is a second record");
            bw1.write("\n");

            System.out.println("Writing file 1 successfully!");

            // B3: Close the stream
            bw1.close();
            fw1.close();


            //List all files in the directory 'Demo2"
            if (dir.isDirectory()) {
                String[] list = dir.list();
                for (int i = 0; i < list.length; i++) {
                    System.out.println("File " + (i+1) + ": " + list[i]);
                }
            }

            //Get absolute path file of director


        } catch (IOException e) {
            System.out.println("Error in writing/open file: " + e);
        }
    }
}
