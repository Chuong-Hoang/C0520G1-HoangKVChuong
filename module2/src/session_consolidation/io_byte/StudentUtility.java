package session_consolidation.io_byte;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentUtility {
    private static List<Student> studentList = new ArrayList<>();
    private static final String STUDENT_FILE_PATH = "src/session_consolidation/io_byte/Student.txt";

    //Create a text file
    static File studentTextFile = new File(STUDENT_FILE_PATH);

    //Read the student text file
    public static List<Student> readStudentFile() {
        //Clear the list before add new students read from the file
        studentList.clear();

        try {
            //Create a stream and link to source
            FileInputStream fileInputStream = new FileInputStream(studentTextFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            //Read the stream
            Student student;

            while ((student = (Student) objectInputStream.readObject()) != null) {
                //Using down-casting and mechanism of deserialization
                studentList.add(student);
            }
            //Close the stream
            fileInputStream.close();
            objectInputStream.close();
        } catch (EOFException e) {
            //System.out.println();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return studentList;
    }

    //Write the student text file
    public static void writeStudentFile(List<Student> studentList) {
        try {
            //Create a stream and link to source
            FileOutputStream fileOutputStream = new FileOutputStream(studentTextFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            //Write the file
            for (Student student : studentList) {
                //Using mechanism of serialization
                objectOutputStream.writeObject(student);
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
