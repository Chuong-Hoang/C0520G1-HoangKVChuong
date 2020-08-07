package james_case_study;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReaderAndWriter {
    private static Map<String, Entity> entityTreeMap = new TreeMap<>();
    private static final String FILE_PATH = "src/james_case_study/Dictionary.txt";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "Name,Pronounce,Meaning,Word_Class,Synonym";

    //Create a file
    static File dict = new File(FILE_PATH);

    public static Map<String, Entity> readFile() {
        entityTreeMap.clear();
        try {
            if(!dict.exists()){
                System.out.println("File does not exist.");
            } else {
                //Create a stream and link to source
                FileReader fileReader = new FileReader(dict.getAbsoluteFile());
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                //Read the stream
                String line;
                String[] arrayString;
                Entity newEntity = null;
                while((line = bufferedReader.readLine()) != null) {
                    arrayString = line.split(",");
                    if ("Name".compareTo(arrayString[0]) == 0) {
                        continue;
                    }
                    String name = arrayString[0];
                    String pronoun = arrayString[1];
                    String meaning = arrayString[2];
                    String wordClass = arrayString[3];
                    String[] synonym = arrayString[4].split(",");
                    newEntity = new Entity(name, pronoun, meaning, wordClass, synonym);
                    entityTreeMap.put(name, newEntity);
                }

                //Close the stream
                fileReader.close();
                bufferedReader.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return entityTreeMap;
    }

    public static void writeFile(Map<String, Entity> entityTreeMap) {
        try {
            if(!dict.exists()) {
                dict.createNewFile();
            }
            //Create a stream and link to source
            FileWriter fileWriter = new FileWriter(dict.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(FILE_HEADER);
            stringBuilder.append(NEW_LINE_SEPARATOR);

            //Write to file
            if (entityTreeMap.isEmpty()) {
                System.out.println("The map-list is empty. Please define new word.");
            } else {
                String[] synonym = null;
                for (Entity entity : entityTreeMap.values()) {
                    stringBuilder.append(entity.getName());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(entity.getPronoun());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(entity.getMeaning());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(entity.getWordClass());
                    stringBuilder.append(COMMA_DELIMITER);

                    synonym = entity.getSynonym();
                    for(int i = 0; i < synonym.length; i++) {
                        stringBuilder.append(synonym[i]);
                        if(i != synonym.length-1) {
                            stringBuilder.append("\"\"");
                        }
                    }

                    stringBuilder.append(NEW_LINE_SEPARATOR);
                }
                bufferedWriter.append(stringBuilder);
            }

            //Close the stream
            bufferedWriter.flush();
            fileWriter.flush();
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
