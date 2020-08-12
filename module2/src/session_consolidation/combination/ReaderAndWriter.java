package session_consolidation.combination;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriter {
    public static final String FILE_PATH = "src/session_consolidation/combination/worker.txt";
    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE_SEPARATOR = "\n";

    //Create a file
    static File workerFile = new File(FILE_PATH);

    //Read the file
    public static List<Worker> readWorkerFile() {
        List<Worker> workerList = new ArrayList<>();
        try {
            if (!workerFile.exists()) {
                workerFile.createNewFile();
            } else {
                //Create a stream and link to source
                FileInputStream fileInputStream = new FileInputStream(workerFile.getAbsoluteFile());
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                //read the stream
                Worker outputWorker;
                while ((outputWorker = (Worker) objectInputStream.readObject()) != null) {
                    workerList.add(outputWorker);
                }

                //Close the stream
                fileInputStream.close();
                objectInputStream.close();
            }
        } catch (EOFException e) {
            // doing nothing here
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return workerList;
    }

    public static void writeWorkerFile(List<Worker> workerList) {
        try {
            //create a stream and link to source
            FileOutputStream fileOutputStream = new FileOutputStream(workerFile.getAbsoluteFile());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            //write the stream
            if(workerList.isEmpty()) {
                System.out.println("The list is empty. Please add new worker...");
            } else {
                for(Worker worker : workerList) {
                    objectOutputStream.writeObject(worker);
                }
            }

            //Close the stream
            objectOutputStream.flush();
            fileOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
