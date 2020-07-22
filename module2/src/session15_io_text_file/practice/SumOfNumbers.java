package session15_io_text_file.practice;
import java.io.*;

public class SumOfNumbers {
    public static void main(String[] args) {
        File file = new File("src/session15_io_text_file/practice/Number.txt");
        sumOfNumbers(file);
    }

    public static void sumOfNumbers(File file) {
        int sum = 0;
        if (!file.exists()) {
            System.out.println("File does not exist.");
        } else {
            try {
                // Step 1: Create a stream and link to source
                FileReader fileReader = new FileReader(file);

                // Step 2: Read the file and calculate summary
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    try {
                        sum += Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        System.out.println("File may contain a character that is not number: " + e);
                    }
                }

                // Close the stream
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error happens: " + e);
            } finally {
                System.out.println("The summary is: " + sum);
            }
        }
    }
}
