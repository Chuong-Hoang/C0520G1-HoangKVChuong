package session15_io_text_file.homeworks;
import java.io.*;

public class CopyTextFile {
    public static void main(String[] args) {
        File file = new File("src/session15_io_text_file/homeworks/Original.txt");
        StringBuffer stringBuffer = readTextFile(file);
        writeTextFile(stringBuffer);
    }

    public static StringBuffer readTextFile(File file) {
        StringBuffer stringBuffer = null;
        if (!file.exists()) {
            System.out.println("File does not exist.");
        } else {
            try {
                //B1: Create a stream and link to source
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                stringBuffer = new StringBuffer();

                //B2: Read file
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line);
                    stringBuffer.append("\n");
                }

                //B3: Close the stream
                bufferedReader.close();
                fileReader.close();

            } catch (IOException e) {
                System.out.println("Error in fileWriter: " + e);
            }
        }
        return stringBuffer;
    }

    public static void writeTextFile(StringBuffer stringBuffer) {
        File file = new File("src/session15_io_text_file/homeworks/Destination.txt");
        try {
            //B1: Create a stream and link to source
            FileWriter fileWriter = new FileWriter(file, true);

            //B2: Write file
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(stringBuffer));

            //B3: Close the stream
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
