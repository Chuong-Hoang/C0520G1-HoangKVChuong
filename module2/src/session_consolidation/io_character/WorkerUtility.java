package session_consolidation.io_character;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerUtility {
    private static List<WorkerFactory> workerFactoryList = new ArrayList<>();
    private static final String WORKER_FILE_PATH = "src/session_consolidation/io_character/WorkerFactory.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "Worker_Id,Name,Age,Salary";

    //Create a file
    private static File workerCsvFile = new File(WORKER_FILE_PATH);

    //Read the csv File
    public static List<WorkerFactory> readWorkerFile() {
        try {
            //Clear the list before adding new workers
            workerFactoryList.clear();

            //Create a stream and link to source
            FileReader fileReader = new FileReader(workerCsvFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //Read the stream of character
            String id;
            String name;
            int age;
            int salary;
            WorkerFactory outputWorker;
            String[] workerStringArray;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                workerStringArray = line.split(",");
                if ("Worker_Id".compareTo(workerStringArray[0]) == 0) {
                    continue;
                }
                id = workerStringArray[0];
                name = workerStringArray[1];
                age = Integer.parseInt(workerStringArray[2]);
                salary = Integer.parseInt(workerStringArray[3]);
                outputWorker = new WorkerFactory(id, name, age, salary);

                //Add new worker into the list
                workerFactoryList.add(outputWorker);
            }

            //Close the stream (out_of_the_loop)
            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println(e);
        }
        return workerFactoryList;
    }

    //Write the worker file
    public static void writeWorkerFile(List<WorkerFactory> workerFactoryList) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {

            //Create a stream and link to source
            fileWriter = new FileWriter(workerCsvFile.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);

            //Write the file
            if (!workerFactoryList.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(FILE_HEADER);
                stringBuilder.append(NEW_LINE_SEPARATOR);

                for (WorkerFactory worker : workerFactoryList) {
                    stringBuilder.append(worker.getId());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(worker.getName());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(worker.getAge());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(worker.getSalary());
                    stringBuilder.append(NEW_LINE_SEPARATOR);
                }

                bufferedWriter.append(stringBuilder);

            } else {
                System.out.println("The list is empty. Please add new worker...");
            }

            //Close the stream
            bufferedWriter.flush();
            fileWriter.flush();
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
